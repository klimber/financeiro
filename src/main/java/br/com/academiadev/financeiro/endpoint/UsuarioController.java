package br.com.academiadev.financeiro.endpoint;

import br.com.academiadev.financeiro.model.Usuario;
import br.com.academiadev.financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return StreamSupport.stream(usuarioRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/usuarios")
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuarios")
    public void delete(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
