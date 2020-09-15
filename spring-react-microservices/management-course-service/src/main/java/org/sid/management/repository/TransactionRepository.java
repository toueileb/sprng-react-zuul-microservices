package org.sid.management.repository;


import org.sid.management.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends IGenericDao<Transaction>, CrudRepository<Transaction, Long> {
//    List<Transaction> findAllTransactionsOfUser(Long userId);
//
////    @Query(value = "select * from transaction", nativeQuery = true)
//    List<Transaction> findAllById(Long courseId);

}
