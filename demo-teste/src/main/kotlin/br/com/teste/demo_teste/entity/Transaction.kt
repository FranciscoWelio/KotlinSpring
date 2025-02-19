package br.com.teste.demo_teste.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotBlank

@Entity
open class Transaction(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long=0
    @NotBlank(message = "Account não pode ser vazio")
    internal var account: String = ""
    @NotNull(message = "Valor não pode ser nula")
    internal var amount: Double = 0.0
    @NotBlank(message = "MCC não pode ser vazio")
    internal var mcc: String = ""
    @NotBlank(message = "Merchant não pode ser vazio")
    internal var merchant: String = ""
}