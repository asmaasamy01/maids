package com.maids.liberary.manager.service.mapper;

import com.maids.liberary.manager.data.book.Book;
import com.maids.liberary.manager.data.patron.Patron;
import com.maids.liberary.manager.service.response.BookObj;
import com.maids.liberary.manager.service.response.PatronObj;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {

    public BookObj mapBookModelToObj(Book bookModel){
        BookObj bookObj=new BookObj();
        bookObj.setId(bookModel.getId().intValue());
        bookObj.setTitle(bookModel.getTitle());
        bookObj.setAuthor(bookModel.getAuthor());
        bookObj.setPublicationYear(bookModel.getPublicationYear());
        return bookObj;
    }

    public PatronObj mapPatronModelToObj(Patron patronModel){
        PatronObj patronObj=new PatronObj();
        patronObj.setId(patronModel.getId().intValue());
        patronObj.setName(patronModel.getName());
        patronObj.setDial(patronModel.getDial());
        patronObj.setAddress(patronModel.getAddress() );
        return patronObj;
    }
}
