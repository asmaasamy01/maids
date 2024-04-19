package com.maids.liberary.manager.data.borrowing;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Borrowing{
	@Id 
	@SequenceGenerator(name = "BORROWING_GEN", sequenceName = "seq_borrowing",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BORROWING_GEN")
   private Long id;
    public Long id() {
		return id;
	}
    public Borrowing() {
    	
    }
	public Borrowing(Long id, Integer bookId, Integer patronId, LocalDateTime borrowingDate, LocalDateTime returnDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.patronId = patronId;
		this.borrowingDate = borrowingDate;
		this.returnDate = returnDate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer bookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer patronId() {
		return patronId;
	}
	public void setPatronId(Integer patronId) {
		this.patronId = patronId;
	}
	public LocalDateTime borrowingDate() {
		return borrowingDate;
	}
	public void setBorrowingDate(LocalDateTime borrowingDate) {
		this.borrowingDate = borrowingDate;
	}
	public LocalDateTime returnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	private Integer bookId;
    private Integer patronId;
    private LocalDateTime borrowingDate;
    private  LocalDateTime returnDate;
public Borrowing updateReturnDate(){
     return new Borrowing(this.id,this.bookId,this.patronId,this.borrowingDate,LocalDateTime.now());
}

}
