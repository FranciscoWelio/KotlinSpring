package br.com.teste.demo_teste.service

import br.com.teste.demo_teste.entity.Usuario
import br.com.teste.demo_teste.exception.UsuarioException
import br.com.teste.demo_teste.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UsuarioService(private var usuarioRepository : UsuarioRepository) {
    fun addUsuario(usuario: Usuario) :Usuario{
        var jaExiste: Boolean= usuarioRepository.existsById(usuario.id)
        if (jaExiste==true){
            throw UsuarioException("Usuário Cadastrado")
        }
        if(usuario.conta.isBlank()){
            throw UsuarioException("Conta vazia")
        }
        if(usuario.nome.isBlank()){
            throw UsuarioException("Nome vazio")
        }
        if(usuario.meal <=0.0 || usuario.food <= 0.0 || usuario.cash <= 0.0){
            usuario.meal =0.0
            usuario.food = 0.0
            usuario.cash = 0.0
            return usuarioRepository.save(usuario)
        }
        return usuarioRepository.save(usuario)

    }
    fun  getUsuario(id: Long):Optional<Usuario>{
        return usuarioRepository.findById(id)
    }

}