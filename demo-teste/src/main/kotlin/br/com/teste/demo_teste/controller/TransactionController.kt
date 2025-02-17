package br.com.teste.demo_teste.controller

import br.com.teste.demo_teste.entity.Transaction
import br.com.teste.demo_teste.request.TransactionReq
import br.com.teste.demo_teste.service.TransactionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController(private var transactionService: TransactionService) {


    @PostMapping("fazendo-transaction")
    fun fazerTransaction(@RequestBody  requisition: TransactionReq):Transaction{
        return transactionService.fazerTransaction(requisition.usuarioId, requisition.merchantId, requisition.amount)
    }

    @GetMapping("/{id}")
    fun getTransaction(@PathVariable("id") id:Long):Transaction{
        return transactionService.getTransaction(id).orElse(null)
    }
}