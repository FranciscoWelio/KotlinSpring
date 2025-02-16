package br.com.teste.demo_teste.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
open class Transaction {
    @Id
    private var id: Long = 0
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private val usuario: Usuario = TODO()
    private var account: String
        get() = ""
        set(value) = TODO()
    private var mcc: String
        get() = ""
        set(value) = TODO()
    private var merchant: String
        get() = ""
        set(value) = TODO()

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private val loja: Merchant
}