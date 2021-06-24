package br.com.zupedu.transactions.controllers;

import br.com.zupedu.transactions.dtos.TransactionResponse;
import br.com.zupedu.transactions.entities.Transaction;
import br.com.zupedu.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class SearchLastTransactions {

    private TransactionRepository transactionRepository;

    @Autowired
    public SearchLastTransactions(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionResponse>> search(@PathVariable("id") String cardId) {

        Optional<Transaction> checkTransaction = transactionRepository.findFirstByCardId(cardId);

        if (checkTransaction.isEmpty()) return ResponseEntity.notFound().build();

        List<Transaction> listTransaction = transactionRepository.findTop10ByCardIdOrderByEffectedInDesc(cardId);

        List<TransactionResponse> listResponse = listTransaction
                .stream().map(TransactionResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(listResponse);
    }
}
