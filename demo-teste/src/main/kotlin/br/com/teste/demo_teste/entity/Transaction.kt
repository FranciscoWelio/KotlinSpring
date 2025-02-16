package br.com.teste.demo_teste.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
open class Transaction {
    @Id
    internal var id: Long = 0
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    internal lateinit var  usuario: Usuario
//    internal var account: String=""
    internal var mcc: String=""
//    internal var merchant: String=""

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    internal lateinit var loja: Merchant
}