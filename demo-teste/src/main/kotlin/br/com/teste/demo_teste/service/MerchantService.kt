package br.com.teste.demo_teste.service

import br.com.teste.demo_teste.entity.Merchant
import br.com.teste.demo_teste.exception.MerchantException

import br.com.teste.demo_teste.repository.MerchantRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MerchantService(private var merchantRepository :MerchantRepository) {
    fun addMerchant(merchant: Merchant): Merchant{
        var jaExiste: Boolean = merchantRepository.existsById(merchant.id)

        if (jaExiste==true){
            throw MerchantException("Mercador já Cadastrado")
        }
        if((merchant.mcc=="5412"|| merchant.mcc =="5411")){
            merchant.nome += " Mercado"
            return merchantRepository.save(merchant)
        }else if((merchant.mcc=="5812"|| merchant.mcc =="5811") ){
            merchant.nome += " Restaurante"
            return merchantRepository.save(merchant)
        }
        return merchantRepository.save(merchant)
    }

    fun  getMerchant(id: Long): Optional<Merchant> {
        return merchantRepository.findById(id)
    }
}