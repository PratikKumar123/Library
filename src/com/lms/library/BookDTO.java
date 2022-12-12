package com.lms.library;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDTO {
	Scanner sc = new Scanner(System.in);
	private static ArrayList<Book> bookList = new ArrayList<Book>();

	public BookDAO bookDAO() {
		return new BookDAOImp();
	}

	public static ArrayList<Book> getBookList() {
		return bookList;
	}

	public static void setBookList(ArrayList<Book> bookList) {
		BookDTO.bookList = bookList;
	}

	public void checkIfEmpty() {
		if (bookList.isEmpty()) {
			System.out.println(" Please search a right book , or we do not have any existence of that book");
		}
	}

	public class BookDAOImp implements BookDAO {

		@Override
		public void addBook(Book book) {
			bookList.add(book);

		}

		@Override
		public ArrayList<Book> searchBookByTitle(String bookTitle) {
			checkIfEmpty();
			for (Book t : bookList) {
				if (t.getBookTitle().equals(bookTitle)) {
					System.out.println("Books Information are : - Author of book is : " + t.getBookAuthor()
							+ " book Edition is " + t.getBookEdition());
					System.out.println(" book genre is : " + t.getBookGenre() + " book price is " + t.getBookPrice());
				} else {
					System.out.println("Enter title or your book is not added yet");
				}
			}
			return null;
		}

		@Override
		public ArrayList<Book> searchBookByAuthor(String bookAuthor) {
			checkIfEmpty();
			for (Book a : bookList) {
				if (a.getBookAuthor().equals(bookAuthor)) {
					System.out.println("Books Information are : - Title of book is : " + a.getBookTitle()
							+ " book Edition is " + a.getBookEdition());
					System.out.println(" book genre is : " + a.getBookGenre() + " book price is " + a.getBookPrice());
				} else {
					System.out.println("Enter correct Author or your book is not added yet");
				}
			}
			return null;
		}

		@Override
		public Book search(String bookTitle, String bookAuthor, String bookGenre, int bookEdition, int bookPrice) {
			checkIfEmpty();
			for (Book s : bookList) {
				if (s.getBookTitle().equals(bookTitle) && s.getBookAuthor().equals(bookAuthor)
						&& s.getBookGenre().equals(bookGenre) && s.getBookEdition() == bookEdition
						&& s.getBookPrice() == bookPrice) {
					System.out.println("Books Information are : - Title of book is : " + s.getBookTitle()
							+ " book Edition is " + s.getBookEdition() + "book Author is " + s.getBookAuthor());
					System.out.println(" book genre is : " + s.getBookGenre() + " book price is " + s.getBookPrice());
				} else {
					System.out.println(" your book is not added yet");
				}
			}

			return null;
		}

		@Override
		public boolean updateBook(Book book) {
			checkIfEmpty();

			System.out.println("Which of the field you want to update \n Click 1 to update Title \n, "
					+ "Click 2 to update Author \n" + "Click 3 to update Genre \n" + "Click 4 to update Edition \n "
					+ "Click 5 to update Price \n");

			System.out.println("Enter no between 1 to 6 : ");

			int chnge = sc.nextInt();

			if (chnge == 1) {

				System.out.println("Enter  Title of the Book to update existing data");
				String bookTitle = sc.next();
				bookList.get(0).setBookTitle(bookTitle);

			} else if (chnge == 2) {
				System.out.println("Enter  bookAuthor of the Book to update existing data");
				String bookAuthor = sc.next();
				bookList.get(0).setBookAuthor(bookAuthor);
			} else if (chnge == 3) {
				System.out.println("Enter  bookGenre of the Book to update existing data");
				String bookGenre = sc.next();
				bookList.get(0).setBookGenre(bookGenre);
			}

			else if (chnge == 4) {
				System.out.println("Enter  bookEdition of the Book to update existing data");
				int bookEdition = sc.nextInt();
				bookList.get(0).setBookEdition(bookEdition);
			} else if (chnge == 5) {
				System.out.println("Enter  bookPrice of the Book to update existing data");
				int bookPrice = sc.nextInt();
				bookList.get(0).setBookPrice(bookPrice);
			}

			else {
				System.out.println("Can't modify ! please enter no between 1 to 5");

			}

			return false;
		}

		@Override
		public boolean removeBook(Book book) {
			checkIfEmpty();

			int index = searchBook(book);

			if (index == -1) {
				return false;
			}
			bookList.remove(index);
			return true;

		}

		public int searchBook(Book book) {
			int i = 0;
			for (Book book2 : bookList) {
				if (book2.getBookTitle().equals(book.getBookTitle())
						&& book2.getBookAuthor().equals(book.getBookAuthor())
						&& book2.getBookGenre().equals(book.getBookGenre())
						&& book2.getBookEdition() == book.getBookEdition()
						&& book2.getBookPrice() == book.getBookPrice()) {
					return i;

				}
				i++;
			}
			return -1;

		}

	}
}
