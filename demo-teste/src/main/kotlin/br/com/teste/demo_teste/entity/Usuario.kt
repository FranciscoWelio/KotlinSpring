package br.com.teste.demo_teste.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
open class Usuario {
    @Id
    internal var id: Long = 0
    internal var nome: String
        get() = ""
        set(value) = TODO()
    internal var conta: String
        get() = ""
        set(value) = TODO()
}