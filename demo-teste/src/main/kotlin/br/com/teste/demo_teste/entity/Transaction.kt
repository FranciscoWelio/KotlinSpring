package br.com.teste.demo_teste.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
open class Transaction(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long=0
    internal var account: String = ""
    internal var amount: Double = 0.0
    internal var mcc: String = ""
    internal var merchant: String = ""
}