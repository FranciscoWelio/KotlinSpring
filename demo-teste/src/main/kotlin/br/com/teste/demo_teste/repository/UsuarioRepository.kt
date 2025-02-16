package br.com.teste.demo_teste.repository

import br.com.teste.demo_teste.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}