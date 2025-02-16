package br.com.teste.demo_teste.repository

import br.com.teste.demo_teste.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<Transaction, Long> {
}