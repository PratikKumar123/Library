package com.lms.library;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDTO {
	Scanner sc = new Scanner(System.in);
	private static ArrayList<Book> bookList = new ArrayList<Book>();
	
	public BookDAO bookDAO()
	{
		return new BookDAOImp();
	}
	
	public static ArrayList<Book> getBookList() {
		return bookList;
	}

	public static void setBookList(ArrayList<Book> bookList) {
		BookDTO.bookList = bookList;
	}


	public class BookDAOImp implements BookDAO
	{

		@Override
		public void addBook(Book book) {
			bookList.add(book);
			
		}

		@Override
		public ArrayList<Book> searchBookByTitle(String bookTitle) {
			
			for(Book t : bookList) {
				if(t.getBookTitle().equals(bookTitle)) {
					System.out.println("Books Information are : - Author of book is : "+t.getBookAuthor() + " book Edition is " +t.getBookEdition());
					System.out.println(" book genre is : "+t.getBookGenre() + " book price is " +t.getBookPrice());
				}else {
					System.out.println("Enter correct title or your book is not added yet");
				}
			}
			return null;
		}

		@Override
		public ArrayList<Book> searchBookByAuthor(String bookAuthor) {
			for(Book a : bookList) {
				if(a.getBookAuthor().equals(bookAuthor)) {
					System.out.println("Books Information are : - Title of book is : "+a.getBookTitle() + " book Edition is " +a.getBookEdition());
					System.out.println(" book genre is : "+a.getBookGenre() + " book price is " +a.getBookPrice());
				}else {
					System.out.println("Enter correct Author or your book is not added yet");
				}
			}
			return null;
		}

		@Override
		public Book search(String bookTitle, String bookAuthor, String bookGenre, int bookEdition, int bookPrice) {
			
			for(Book s : bookList) {
				if(s.getBookTitle().equals(bookTitle) && s.getBookAuthor().equals(bookAuthor) && s.getBookGenre().equals(bookGenre) && s.getBookEdition()==bookEdition &&s.getBookPrice()==bookPrice ) {
					System.out.println("Books Information are : - Title of book is : "+s.getBookTitle() + " book Edition is " +s.getBookEdition() + "book Author is "+s.getBookAuthor());
					System.out.println(" book genre is : "+s.getBookGenre() + " book price is " +s.getBookPrice());
				}else {
					System.out.println(" your book is not added yet");
				}
			}
			
			
			return null;
		}

		@Override
		public boolean updateBook(Book book) {
			System.out.println("Which of the field you want to update \n Click 1 to update Title \n, "
					+ " Click 2 to update Author \n" + " Click 3 to update Genre \n" + "Click 4 to update Edition \n "+"Click 5 to update Price \n");
			
			System.out.println("Enter no between 1 to 6 : ");
			
			int chnge = sc.nextInt();
			if(chnge == 1) {
				
				Book b1 = new Book();
				
				System.out.println("Enter to update title :");
				String bt = sc.next();
				
				b1.setBookTitle(bt);

			}
			else if( chnge == 2) {
				Book b2 = new Book();
				
				System.out.println("Enter to update bookAuthor :");
				String bt2 = sc.next();
				
				b2.setBookAuthor(bt2);
			}
			else if( chnge == 3) {
				Book b3 = new Book();
				
				System.out.println("Enter to update title :");
				String bt3 = sc.next();
				
				b3.setBookGenre(bt3);
			}
			else if( chnge == 4) {
				Book b4 = new Book();
				
				System.out.println("Enter to update title :");
				int bt4 = sc.nextInt();
				
				b4.setBookEdition(bt4);;
			}
			else if( chnge == 5) {
				Book b5 = new Book();
				
				System.out.println("Enter to update title :");
				int bt5 = sc.nextInt();
				
				b5.setBookPrice(bt5);;
			}
			else  {
				System.out.println("Can't modify ! please enter no between 1 to 6");
				
			}

			
			return false;
		}

		@Override
		public boolean removeBook(Book book) {
			
			ArrayList<Book> bookList = BookDTO.getBookList();
			
			if(bookList.equals(book)) {
				
//				bookList.remove(book);
//				
//				System.out.println("Book deleted successfully");
				
			}else {
				System.out.println("Enter details correctly or your book is not found");
			}
			
			
			return false;
		}

		@Override
		public int searchBook(Book book) {
			// TODO Auto-generated method stub
			return 0;
		}
				

	}
}
