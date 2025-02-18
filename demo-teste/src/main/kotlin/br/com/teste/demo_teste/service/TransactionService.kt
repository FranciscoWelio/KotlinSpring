package br.com.teste.demo_teste.service

import br.com.teste.demo_teste.entity.Merchant
import br.com.teste.demo_teste.entity.Transaction
import br.com.teste.demo_teste.entity.Usuario
import br.com.teste.demo_teste.exception.TransactionException
import br.com.teste.demo_teste.exception.UsuarioException
import br.com.teste.demo_teste.repository.MerchantRepository
import br.com.teste.demo_teste.repository.TransactionRepository
import br.com.teste.demo_teste.repository.UsuarioRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.transaction.Transactional
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Suppress("UNREACHABLE_CODE")
@Service
class TransactionService(private var transactionRepository :TransactionRepository,
                         private var usuarioRepository: UsuarioRepository,
                         private var merchantRepository: MerchantRepository) {

    @Transactional
    fun fazerTransaction(usuarioId: Long, merchantId:Long, amount:Double ):Transaction {
        val usuarioOP: Optional<Usuario> = usuarioRepository.findById(usuarioId)
        val usuario = usuarioOP.get()
        val merchantOP: Optional<Merchant> = merchantRepository.findById(merchantId)
        val merchant = merchantOP.get()
        if (merchant.mcc == "5411" || merchant.mcc =="5412"){
            if (usuario.food<amount &&  usuario.cash>=amount){
                usuario.cash -= amount
                usuarioRepository.save(usuario)

            }else if(usuario.food<amount &&  usuario.cash<amount){
                throw UsuarioException("Saldo insuficiente")
            }else{
                usuario.food -= amount
                usuarioRepository.save(usuario)
            }

        }else if (merchant.mcc == "5811" || merchant.mcc =="5812"){
            if (usuario.meal<amount &&  usuario.cash>=amount){
                usuario.cash -= amount
                usuarioRepository.save(usuario)
            }else if(usuario.meal<amount &&  usuario.cash<amount){
                throw UsuarioException("Saldo insuficiente")

            }else{
                usuario.meal -= amount
                usuarioRepository.save(usuario)
            }
        }else if(merchant.mcc != "5811" && merchant.mcc != "5812" && merchant.mcc != "5411" && merchant.mcc != "5412"){
            if (usuario.cash<amount){
                throw UsuarioException("Saldo insuficiente")
            }
            usuario.cash -= amount
            usuarioRepository.save(usuario)
        }
            val merchantLocal = merchant.nome +" "+ merchant.localizacao
            var transaction :Transaction = Transaction()
            transaction.amount = amount
            transaction.account = usuario.conta
            transaction.mcc = merchant.mcc
            transaction.merchant = merchantLocal
        return transactionRepository.save(transaction)
    }

    fun  getTransaction(id: Long): Optional<Transaction> {
        return transactionRepository.findById(id)
    }
}