package br.com.teste.demo_teste.entity


import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

@Entity
open class Usuario(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long=0
    @NotBlank(message = "Nome não pode ser vazio")
    internal var nome: String = ""
    @NotBlank(message = "Conta não pode ser vazio")
    @Column(unique = true)
    @Pattern(regexp = "\\d{4}-\\d{1}", message = "A conta deve estar no formato 1234-5")
    internal var conta: String = ""
    @NotNull(message = "Valor Meal não pode ser nula")
    internal var meal: Double = 0.0
    @NotNull(message = "Valor Food não pode ser nula")
    internal var food: Double = 0.0
    @NotNull(message = "Valor Cash não pode ser nula")
    internal var cash: Double = 0.0
}