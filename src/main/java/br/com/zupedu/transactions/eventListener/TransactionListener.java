package br.com.zupedu.transactions.eventListener;

import br.com.zupedu.transactions.dtos.TransactionEvent;
import br.com.zupedu.transactions.entities.Transaction;
import br.com.zupedu.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionListener(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionEvent transactionEvent) {
        Transaction transaction = transactionEvent.toModel();
        transactionRepository.save(transaction);
    }
}
