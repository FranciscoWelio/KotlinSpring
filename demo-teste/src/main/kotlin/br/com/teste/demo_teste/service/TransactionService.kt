package br.com.teste.demo_teste.service

import br.com.teste.demo_teste.entity.Transaction
import br.com.teste.demo_teste.exception.TransactionException
import br.com.teste.demo_teste.repository.TransactionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(private var transactionRepository :TransactionRepository) {

    fun createTransaction(transaction: Transaction): Transaction{
        var jaExiste: Boolean = transactionRepository.existsById(transaction.id)
        if (jaExiste==true){
            throw TransactionException("Transação já Existente")
        }
        return transactionRepository.save(transaction)
    }

    fun  getTransaction(id: Long): Optional<Transaction> {
        return transactionRepository.findById(id)
    }
}