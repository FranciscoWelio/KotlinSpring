package br.com.teste.demo_teste.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
open class Merchant {
    @Id
    internal var id: Long =0
    internal var tipo : String=""
    internal var nome : String=""
    internal var localizacao: String =""
}