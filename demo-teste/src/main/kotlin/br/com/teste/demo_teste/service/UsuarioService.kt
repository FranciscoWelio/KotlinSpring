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
        return usuarioRepository.save(usuario)

    }
    fun  getUsuario(id: Long):Optional<Usuario>{
        return usuarioRepository.findById(id)
    }

}