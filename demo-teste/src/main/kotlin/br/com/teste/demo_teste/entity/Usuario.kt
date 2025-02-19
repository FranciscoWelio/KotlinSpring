package br.com.teste.demo_teste.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotBlank

@Entity
open class Usuario(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long=0
    @NotBlank(message = "Nome não pode ser vazio")
    internal var nome: String = ""
    @NotBlank(message = "Conta não pode ser vazio")
    internal var conta: String = ""
    @NotNull(message = "Valor Meal não pode ser nula")
    internal var meal: Double = 0.0
    @NotNull(message = "Valor Food não pode ser nula")
    internal var food: Double = 0.0
    @NotNull(message = "Valor Cash não pode ser nula")
    internal var cash: Double = 0.0
}