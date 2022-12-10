package com.lms.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Librarian extends Thread implements Serializable{
	
	private Scanner sc = new Scanner(System.in);
	char c;
	public void access()
	{
		BookDTO bookDTO = new BookDTO();
		BookDAO bookAccessObject = bookDTO.bookDAO();
		
		
		do{
			
		
		System.out.println("Press 1 to add a book...");
		System.out.println("Press 2 to Search book...");
		System.out.println("Press 3 to Search book using author...");
		System.out.println("Press 4 to Search book using title...");
		System.out.println("Press 5 to update book...");
		System.out.println("Press 6 to remove book...");
		System.out.println("Enter your choice....");
		System.out.println();
		int choice  = sc.nextInt();
		if(choice == 1)
		{
			System.out.println("Enter bookTitle : ");
			String bookTitle = sc.next();
			
			System.out.println("Enter bookAuthor : ");
			String bookAuthor = sc.next();
			
			System.out.println("Enter bookGenre : ");
			String bookGenre = sc.next();
			
			System.out.println("Enter bookEdition : ");
			int bookEdition = sc.nextInt();
			
			System.out.println("Enter bookPrice : ");
			int bookPrice = sc.nextInt();
			
			
			Book b = new Book(bookTitle,bookAuthor,bookGenre,bookPrice,bookEdition);
			
			bookAccessObject.addBook(b);
			
			 ArrayList<Book> bookList = BookDTO.getBookList();
			 
			 for(Book b2 : bookList) {
				 System.out.println(b2.toString());
			 }
			 
			 System.out.println("Book added successfully");
			
		}
		else if(choice == 2)
		{
			System.out.println("Enter bookTitle : ");
			String bookTitle = sc.next();
			
			System.out.println("Enter bookAuthor : ");
			String bookAuthor = sc.next();
			
			System.out.println("Enter bookGenre : ");
			String bookGenre = sc.next();
			
			System.out.println("Enter bookEdition : ");
			int bookEdition = sc.nextInt();
			
			System.out.println("Enter bookPrice : ");
			int bookPrice = sc.nextInt();
			
			
			bookAccessObject.search(bookTitle, bookAuthor, bookGenre, bookEdition, bookPrice);
			
			
			
			
		}
		
		else if(choice == 3)
		{
			System.out.println("Enter the book author for searching that perticular book");
			String bookAuthor = sc.next();
			
			bookAccessObject.searchBookByAuthor(bookAuthor);
		}
		 
		else if(choice == 4)
		{
			System.out.println("Enter the book title for searching that perticular book");
			String bookTitle = sc.next();
			
			bookAccessObject.searchBookByTitle(bookTitle);
			
		}
		else if(choice == 5)
		{
			System.out.println("Enter the Book Title");
			String bookTitle = sc.next();

			System.out.println("Enter Book Author Name");
			String bookAuthor = sc.next();

			System.out.println("Enter Book Genre");
			String bookGenre = sc.next();

			System.out.println("Enter the Book Edition");
			int bookEdition= sc.nextInt();

			System.out.println("Enter book price");
			int bookPrice = sc.nextInt();
			Book b = new Book(bookTitle, bookAuthor, bookGenre, bookEdition, bookPrice);

			 bookAccessObject.updateBook(b);
			 System.out.println("Book updated successfully");

		}
		
		else if(choice == 6)
		{
			
			System.out.println("Enter the Book Title");
			String bookTitel = sc.nextLine();

			System.out.println("Enter Book Author Name");
			String bookAuthor = sc.nextLine();

			System.out.println("Enter Book Genre");
			String bookGenre = sc.nextLine();

			System.out.println("Enter the Book Edition");
			int bookEdition= sc.nextInt();

			System.out.println("Enter book price");
			int bookPrice = sc.nextInt();

			ArrayList<Book> bookList = BookDTO.getBookList();


			Book b = new Book(bookTitel, bookAuthor, bookGenre, bookEdition, bookPrice);

			System.out.println(bookAccessObject.removeBook(b));
			
		}
		else
		{
			throw new InvalidChoiceException();
		}
		
		System.out.println("if you want to repeat Enter Y or else Enter some other key");
		
		this.c = sc.next().charAt(0);
		
	}
		while(c=='Y');
}
	@Override
	public void run() {
		access();
		
		
		
		
		super.run();
	}
	
	
}