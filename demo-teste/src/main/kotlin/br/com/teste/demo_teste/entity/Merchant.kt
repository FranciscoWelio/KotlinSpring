package br.com.teste.demo_teste.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank

@Entity
open class Merchant(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long =0
    @NotBlank(message = "MCC não pode ser vazio" )
    internal var mcc : String = ""
    @NotBlank(message = "Nome não pode ser vazio" )
    internal var nome : String = ""
    @NotBlank(message = "Lozalização não pode ser vazio" )
    internal var localizacao: String = ""

}