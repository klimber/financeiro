package br.com.academiadev.financeiro.endpoint;

import br.com.academiadev.financeiro.model.Usuario;
import br.com.academiadev.financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping
public class UsuarioEndpoint {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/usuario")
	public void save(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	@GetMapping("/usuario")
	public List<Usuario> buscarUsuarios() {
		return toList(usuarioRepository.findAll());
	}

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}
}
