package com.multithreading.examples;

public class CourseNotifier {

	public static void main(String[] args) throws InterruptedException {
		//creating course class
		

		final Course course = new Course("Java Multithreaded Programming");
	// creating two student thread waiting for couse completd
		new Thread(() -> {

			synchronized (course) {
				System.out
						.println(Thread.currentThread().getName() + " is waiting for the course " + course.getTitle());

				try {
					course.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out
						.println(Thread.currentThread().getName() + "Course is " + course.getTitle() + " is completed");
			}
		}

				, "Student A").start();
		new Thread(() -> {

			synchronized (course) {
				System.out
						.println(Thread.currentThread().getName() + " is waiting for the course " + course.getTitle());
				try {
					course.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out
						.println(Thread.currentThread().getName() + "Course is " + course.getTitle() + " is completed");

			}

		}

				, "Student B").start();
		Thread.sleep(4000);
		new Thread(() -> {
			synchronized (course) {
				System.out.println(Thread.currentThread().getName() +
						"is starting a new course :" + course.getTitle());
				try {
					Thread.sleep(4000);
					course.notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}

				, "Pankaj").start();

	}

}

class Course {

	private String title;
	private boolean completed;

	public Course(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
