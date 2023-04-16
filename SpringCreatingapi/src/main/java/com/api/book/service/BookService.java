package com.api.book.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> list=new ArrayList<Book>();
//
//	static{
//		list.add(new Book(12,"Python Refrence","dddd"));
//		list.add(new Book(22,"C++ Refrence","aaa"));
//		list.add(new Book(32,"Java Refrence","bbb"));
//		list.add(new Book(42,"JS Refrence","ccc"));
//	}
	//get allbooks
	public List<Book> getAllBooks(){
		List<Book> list=(List<Book>)this.bookRepository.findAll();
		return list;
	}

	//get single book by id
	public Book getSingleBookById(int id){
		Book book=null;
		try {
//			book=list.stream().filter(e->e.getId()==id).findFirst().get();
		    this.bookRepository.findById(id);	
		}catch (Exception e) {
		e.printStackTrace();	
		}
		return book;
	}

	//add methode 
	public Book addBook(Book b) {
	//list.add(b);
	Book result=this.bookRepository.save(b);
		return result;	
	}
	
	//delete book
	public void deleteBook(int bid) {
//		list=list.stream().filter(book->book.getId()!=bid).
//		collect(Collectors.toList());
        this.bookRepository.deleteById(bid);
	}
	
	//update book
	public void updateBook(Book book,int bId)
	{
//		list.stream().map(b->{
//			if(b.getId()==bId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//				 
//			}else
//			{
//				
//			}
//			return b;
//		}).collect(Collectors.toList());
	    book.setId(bId);
		bookRepository.save(book);
	}
	}

