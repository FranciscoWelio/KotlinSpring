package br.com.teste.demo_teste.repository

import br.com.teste.demo_teste.entity.Merchant
import org.springframework.data.jpa.repository.JpaRepository

interface MerchantRepository : JpaRepository<Merchant, Long> {
}