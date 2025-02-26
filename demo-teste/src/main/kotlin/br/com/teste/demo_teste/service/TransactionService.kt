package br.com.teste.demo_teste.service

import br.com.teste.demo_teste.entity.Merchant
import br.com.teste.demo_teste.entity.Transaction
import br.com.teste.demo_teste.entity.Usuario

import br.com.teste.demo_teste.repository.MerchantRepository
import br.com.teste.demo_teste.repository.TransactionRepository
import br.com.teste.demo_teste.repository.UsuarioRepository


import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import java.util.*

@Suppress("UNREACHABLE_CODE")
@Service
class TransactionService(private var transactionRepository :TransactionRepository,
                         private var usuarioRepository: UsuarioRepository,
                         private var merchantRepository: MerchantRepository) {

    @org.springframework.transaction.annotation.Transactional(isolation = Isolation.READ_COMMITTED)
    fun fazerTransaction(usuarioId: Long, merchantId:Long, amount:Double ):String {
        val usuarioOP: Optional<Usuario> = usuarioRepository.findById(usuarioId)
        val usuario = usuarioOP.get()
        val merchantOP: Optional<Merchant> = merchantRepository.findById(merchantId)
        val merchant = merchantOP.get()
        var code: String = ""
        if(amount<0) {
            return "Code: 07"
        }
        if (merchant.mcc == "5411" || merchant.mcc == "5412" || merchant.nome.contains("Mercado", ignoreCase = true)) {
            if (usuario.food < amount && usuario.cash >= amount && amount >0) {
                usuario.cash -= amount
                usuarioRepository.save(usuario)
                createTransaction(amount, usuario.conta, merchant.mcc, merchant.nome, usuarioId, merchantId)
                code = "Code: 00"

            } else if (usuario.food < amount && usuario.cash < amount && amount >0) {
                code ="Code: 51"
            } else {
                usuario.food -= amount
                usuarioRepository.save(usuario)
                createTransaction(amount, usuario.conta, merchant.mcc, merchant.nome, usuarioId, merchantId)
                code = "Code: 00"
            }

        } else if (merchant.mcc == "5811" || merchant.mcc == "5812" || merchant.nome.contains("Restaurante", ignoreCase = true)) {
            if (usuario.meal < amount && usuario.cash >= amount && amount >0) {
                usuario.cash -= amount
                usuarioRepository.save(usuario)
                createTransaction(amount, usuario.conta, merchant.mcc, merchant.nome, usuarioId, merchantId)
                code = "Code: 00"
            } else if (usuario.meal < amount && usuario.cash < amount && amount >0) {
                code = "Code: 51"

            } else {
                usuario.meal -= amount
                usuarioRepository.save(usuario)
                createTransaction(amount, usuario.conta, merchant.mcc, merchant.nome, usuarioId, merchantId)
                code = "Code: 00"
            }
        } else if (merchant.mcc != "5811" || merchant.mcc != "5812" || merchant.mcc != "5411" || merchant.mcc != "5412") {
            if (usuario.cash > amount && amount >0) {
                usuario.cash -= amount
                usuarioRepository.save(usuario)
                createTransaction(amount, usuario.conta, merchant.mcc, merchant.nome, usuarioId, merchantId)
                code = "Code: 00"

            } else {
                code = "Code: 51"
            }
        }

        return code
    }




    fun createTransaction(amount: Double, account:String, mcc:String, localizacao:String, usuarioId:Long, merchantId:Long):Transaction{
        val usuarioOP: Optional<Usuario> = usuarioRepository.findById(usuarioId)
        val usuario = usuarioOP.get()
        val merchantOP: Optional<Merchant> = merchantRepository.findById(merchantId)
        val merchant = merchantOP.get()
        val merchantLocal = merchant.nome + " " + merchant.localizacao
        val transaction :Transaction = Transaction( )
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