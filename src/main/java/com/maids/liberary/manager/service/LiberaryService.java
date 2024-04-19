package com.maids.liberary.manager.service;
import com.maids.liberary.manager.data.book.Book;
import com.maids.liberary.manager.data.book.BookRepository;
import com.maids.liberary.manager.data.borrowing.Borrowing;
import com.maids.liberary.manager.data.borrowing.BorrowingRepository;
import com.maids.liberary.manager.data.patron.Patron;
import com.maids.liberary.manager.data.patron.PatronRepository;
import com.maids.liberary.manager.service.mapper.ObjectMapper;
import com.maids.liberary.manager.service.response.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LiberaryService {

    private static final String SUCCESS = "0";
    private static final String FAIL = "1";

    private  final BookRepository bookRepo;
    private  final PatronRepository patronRepo;
    private final ObjectMapper objectMapper;
    private final BorrowingRepository borrowingRepo;

    public LiberaryService(BookRepository bookRepo, PatronRepository patronRepo, ObjectMapper objectMapper, BorrowingRepository borrowingRepo) {
        this.bookRepo=bookRepo;
        this.patronRepo=patronRepo;
        this.objectMapper = objectMapper;
        this.borrowingRepo = borrowingRepo;
    }

    public BookResponse getBooks(){

        Iterable<Book> books=bookRepo.findAll();
        List<BookObj> bookObjs=new ArrayList<>();
        books.forEach(book -> bookObjs.add(objectMapper.mapBookModelToObj(book)));
        return new BookResponse(bookObjs,SUCCESS,"success");

    }
    public BookResponse findBookById(Integer id){
        List<BookObj> bookObj=new ArrayList<>();
        Optional<Book> book=bookRepo.findById(Long.valueOf(id));
            if(book.isPresent()){
                bookObj.add(objectMapper.mapBookModelToObj(book.get()));
                return new BookResponse(bookObj,SUCCESS,"success");
            }else{
            return new BookResponse(null,FAIL,"No Book for Id "+id);
        }
    }

    public CommonResponse addBook(BookObj bookobj){
       Book book=new Book(null,bookobj.getTitle(), bookobj.getAuthor(), bookobj.getPublicationYear());
       bookRepo.save(book) ;
        return  new CommonResponse(SUCCESS," Book added successfully");
    }

    public CommonResponse updateBook(Integer id,BookObj bookObj){
        Optional<Book> book=bookRepo.findById(Long.valueOf(id));
        if(book.isEmpty()){
            return new CommonResponse(FAIL,"No Book for Id "+id);
        }else{
            bookRepo.save(book.get().updateBook(bookObj.getTitle(),bookObj.getAuthor(),bookObj.getPublicationYear()));
        return  new CommonResponse(SUCCESS," Book with Id "+id+ " updated successfully");
        }
    }

    public CommonResponse deleteBook(Integer id){
        Optional<Book> book=bookRepo.findById(Long.valueOf(id));
        if(book.isEmpty()){
            return new CommonResponse(FAIL,"No Book for Id "+id);
        }else{
            bookRepo.delete(book.get());
            return  new CommonResponse(SUCCESS," Book with Id "+id+ " deleted successfully");
        }
    }
//patron
    public PatronResponse getPatrons(){

        Iterable<Patron> patrons=patronRepo.findAll();
        List<PatronObj> patronObjs=new ArrayList<>();
        patrons.forEach(patron -> patronObjs.add(objectMapper.mapPatronModelToObj(patron)));
        return new PatronResponse(patronObjs,SUCCESS,"success");

    }
    public PatronResponse findPatronById(Integer id){
        List<PatronObj> patronObj=new ArrayList<>();
        Optional<Patron> patron=patronRepo.findById(Long.valueOf(id));
        if(patron.isPresent()){
            patronObj.add(objectMapper.mapPatronModelToObj(patron.get()));
            return new PatronResponse(patronObj,SUCCESS,"success");
        }else{
            return new PatronResponse(null,FAIL,"No Patron for Id "+id);
        }
    }

    public CommonResponse addPatron(PatronObj patronobj){
        Patron patron=new Patron(null,patronobj.getName(), patronobj.getDial(), patronobj.getAddress());
        patronRepo.save(patron) ;
        return  new CommonResponse(SUCCESS," Patron added successfully");
    }

    public CommonResponse updatePatron(Integer id,PatronObj patronObj){
        Optional<Patron> patron=patronRepo.findById(Long.valueOf(id));
        if(patron.isEmpty()){
            return new CommonResponse(FAIL,"No Patron for Id "+id);
        }else{
            patronRepo.save(patron.get().updatePatron(patronObj.getName(),patronObj.getDial(),patronObj.getAddress()));
            return  new CommonResponse(SUCCESS," Patron with Id "+id+ " updated successfully");
        }
    }

    public CommonResponse deletePatron(Integer id){
        Optional<Patron> patron=patronRepo.findById(Long.valueOf(id));
        if(patron.isEmpty()){
            return new CommonResponse(FAIL,"No Patron for Id "+id);
        }else{
            patronRepo.delete(patron.get());
            return  new CommonResponse(SUCCESS," Patron with Id "+id+ " deleted successfully");
        }
    }

    //Borrow

    public CommonResponse borrowBook(Integer bookId,Integer patronId){
        Optional<Patron> patron=patronRepo.findById(Long.valueOf(patronId));
        if(patron.isEmpty()){
            return new CommonResponse(FAIL,"No Patron for Id "+patronId);
        }

        Optional<Book> book=bookRepo.findById(Long.valueOf(bookId));
        if(book.isEmpty()){
            return new CommonResponse(FAIL,"No Book for Id "+bookId);
        }
       Optional<Borrowing> bookAlreadyBorrowed=borrowingRepo.findByBookId(bookId);
        Optional<Borrowing> patronAlreadyBorrow=borrowingRepo.findByPatronId(patronId);
        if(bookAlreadyBorrowed.isPresent()){
            return new CommonResponse(FAIL,"Book with Id "+bookId+" Already borrowed with customer with id "+bookAlreadyBorrowed.get().patronId());
        }
        if(patronAlreadyBorrow.isPresent()){
            return new CommonResponse(FAIL,"patron with Id "+patronId+" already borrow another book with id "+patronAlreadyBorrow.get().bookId());
        }
        Borrowing borrowingMobel=new Borrowing(null,bookId,patronId, LocalDateTime.now(),null);
        borrowingRepo.save(borrowingMobel);
        return new CommonResponse(SUCCESS,"Patron with id "+patronId+" borrow book with id "+bookId+" Successfully");
    }


    public CommonResponse returnBook(Integer bookId,Integer patronId){

        Optional<Borrowing> borrowing= borrowingRepo.findByBookIdAndPatronId(bookId,patronId);
        if(borrowing.isEmpty()){
           return new CommonResponse(FAIL, "No Borrowing record");
        }

        borrowingRepo.save(borrowing.get().updateReturnDate());
        return new CommonResponse(SUCCESS,"return date updated successfully for this borrowing");


    }
}
