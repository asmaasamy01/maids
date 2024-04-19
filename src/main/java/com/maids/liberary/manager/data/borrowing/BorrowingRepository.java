package com.maids.liberary.manager.data.borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    Optional<Borrowing> findByBookId(Integer bookId);
    Optional<Borrowing> findByPatronId(Integer patronId);
    Optional<Borrowing> findByBookIdAndPatronId(Integer bookId,Integer paternId);

}
