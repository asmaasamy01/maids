package com.maids.liberary.manager.controller;
import com.maids.liberary.manager.service.response.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import com.maids.liberary.manager.service.LiberaryService;

@RestController
public class LiberaryController {

	private final LiberaryService liberaryService;

	public LiberaryController(LiberaryService liberaryService) {
		this.liberaryService = liberaryService;
	}

	//Books
	@GetMapping("api/books")
	public BookResponse getAllBooks(){
		return liberaryService.getBooks();
	}

	@GetMapping("api/books/{id}")
	public BookResponse getBook(@Valid @PathVariable("id") @NotNull(message = "id not valid")@Digits(message = "must be numeric", fraction = 0, integer = 4) Integer id){
		return liberaryService.findBookById(id);
	}

	@PostMapping("api/books")
	public CommonResponse addBook(@RequestBody BookObj book) {
		return liberaryService.addBook(book);

	}


	@PutMapping("api/books/{id}")
	public CommonResponse updateBook(@PathVariable("id") @NotNull(message = "id not valid") Integer id,@RequestBody BookObj book){
		return liberaryService.updateBook(id,book);
	}
	@DeleteMapping("api/books/{id}")
	public CommonResponse deleteBook(@PathVariable("id") @NotNull(message = "id not valid") Integer id){
		return liberaryService.deleteBook(id);
	}

	//Patrons

	@GetMapping("api/patrons")
	public PatronResponse getAllPatrons(){
		return liberaryService.getPatrons();
	}

	@GetMapping("api/patrons/{id}")
	public PatronResponse getPatron(@Valid @PathVariable("id") @NotNull(message = "id not valid")@Digits(message = "must be numeric", fraction = 0, integer = 4) Integer id){
		return liberaryService.findPatronById(id);
	}

	@PostMapping("api/patrons")
	public CommonResponse addPatron(@RequestBody PatronObj patron) {
		return liberaryService.addPatron(patron);

	}


	@PutMapping("api/patrons/{id}")
	public CommonResponse updatePatron(@PathVariable("id") @NotNull(message = "id not valid") Integer id,@RequestBody PatronObj patron){
		return liberaryService.updatePatron(id,patron);
	}
	@DeleteMapping("api/patrons/{id}")
	public CommonResponse deletePatron(@PathVariable("id") @NotNull(message = "id not valid") Integer id){
		return liberaryService.deletePatron(id);
	}
	//borowing

	@PostMapping("/api/borrow/{bookId}/patron/{patronId}")
	public CommonResponse borrowBook(@PathVariable("bookId") @NotNull(message = "bookId not valid") Integer bookId, @PathVariable("patronId")@NotNull(message = "patronId not valid")  Integer patronId) {
		return liberaryService.borrowBook(bookId,patronId);
	}
	@PutMapping ("/api/borrow/{bookId}/patron/{patronId}")
	public CommonResponse returnBorrowedBook(@PathVariable("bookId")@NotNull(message = "bookId not valid")  Integer bookId, @PathVariable("patronId")@NotNull(message = "patronId not valid")  Integer patronId) {
		return liberaryService.returnBook(bookId,patronId);
	}

}

