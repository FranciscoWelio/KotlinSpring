package br.com.teste.demo_teste.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
open class Usuario( ){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long=0
    internal var nome: String = ""
    internal var conta: String = ""
    internal var meal: Double = 0.0
    internal var food: Double = 0.0
    internal var cash: Double = 0.0
}