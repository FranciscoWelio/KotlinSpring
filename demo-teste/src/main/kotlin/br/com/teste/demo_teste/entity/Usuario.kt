package br.com.teste.demo_teste.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
open class Usuario() {
    @Id
    internal var id: Long = 0
    internal var nome: String=""
    internal var conta: String=""
    internal var meal: Double =0.0
    internal var food: Double =0.0
    internal var cash: Double =0.0
}