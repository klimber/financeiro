package br.com.academiadev.financeiro.endpoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academiadev.financeiro.model.LancamentoFinanceiro;
import br.com.academiadev.financeiro.repository.LancamentoFinanceiroRepository;

@RestController
@RequestMapping
public class LancamentoEndpoint {

	@Autowired
	private LancamentoFinanceiroRepository lancamentoFinanceiroRepository;

	@PostMapping("/lancamentoFinanceiro")
	public void save(@RequestBody LancamentoFinanceiro lancamentoFinanceiro) {
		lancamentoFinanceiroRepository.save(lancamentoFinanceiro);
	}

	@GetMapping("lancamentoFinanceiro")
	public List<LancamentoFinanceiro> buscarLancamentosFinanceiros() {
		return toList(lancamentoFinanceiroRepository.findAll());
	}

	public <E> List<E> toList(Iterable<E> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

}
