package br.com.teste.demo_teste.controller

import br.com.teste.demo_teste.entity.Merchant
import br.com.teste.demo_teste.service.MerchantService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant")
class MerchantController(private var  merchantService: MerchantService) {


    @PostMapping("/create-merchant")
    fun  addMerchant(@Valid @RequestBody merchant: Merchant) :Merchant{
        return merchantService.addMerchant(merchant)
    }

    @GetMapping("/{id}")
    fun getMerchant(@PathVariable("id") id:Long):Merchant{
        return merchantService.getMerchant(id).orElse(null)
    }

}