package br.com.teste.demo_teste.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
open class Merchant(){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal var id: Long =0
    internal var mcc : String = ""
    internal var nome : String = ""
    internal var localizacao: String = ""

}