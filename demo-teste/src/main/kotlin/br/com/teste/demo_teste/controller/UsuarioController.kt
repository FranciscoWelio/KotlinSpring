package br.com.teste.demo_teste.controller

import br.com.teste.demo_teste.entity.Usuario
import br.com.teste.demo_teste.service.UsuarioService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/usuario")
class UsuarioController {
   var usuarioService: UsuarioService = TODO()


    @PostMapping("/create-user")

    fun addUsuario(@RequestBody usuario: Usuario): Usuario{
        return usuarioService.addUsuario(usuario)
    }

    fun UsuarioController(usuarioService: UsuarioService){
        this.usuarioService = usuarioService
    }

    @GetMapping("/id")
    fun getDemo(@PathVariable("id") id: Long): Usuario{
        return usuarioService.getUsuario(id).orElse(null)
    }

}