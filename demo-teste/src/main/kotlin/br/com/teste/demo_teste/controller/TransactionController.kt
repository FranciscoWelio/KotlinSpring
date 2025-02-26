package br.com.teste.demo_teste.controller

import br.com.teste.demo_teste.entity.Transaction
import br.com.teste.demo_teste.request.TransactionReq
import br.com.teste.demo_teste.service.TransactionService
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/transaction")
class TransactionController(private var transactionService: TransactionService) {


    @PostMapping("fazendo-transaction")
    @Operation(summary = "Cria Transação", description = "Cria uma transação com o Id-Usuario, Id-Loja e valor-de-compra")
    fun fazerTransaction(@Valid @RequestBody  requisition: TransactionReq):String{
         val transction = transactionService.fazerTransaction(requisition.usuarioId, requisition.merchantId, requisition.amount)

        return transction
    }

    @GetMapping("/{id}")
    fun getTransaction(@PathVariable("id") id:Long):Transaction{
        return transactionService.getTransaction(id).orElse(null)
    }
}