package br.com.teste.demo_teste.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
open class Merchant {
    @Id
    private var id: Long =0
    private var tipo : String
        get() = ""
        set(value) = TODO()
    private var nome : String
        get() = ""
        set(value) = TODO()
    private var localizacao: String
        get() = ""
        set(value) = TODO()

}