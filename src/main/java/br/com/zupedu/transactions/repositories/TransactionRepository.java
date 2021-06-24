package br.com.zupedu.transactions.repositories;

import br.com.zupedu.transactions.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<Transaction> findFirstByCardId(String cardId);
    List<Transaction> findTop10ByCardIdOrderByEffectedInDesc(String cardId);
}
