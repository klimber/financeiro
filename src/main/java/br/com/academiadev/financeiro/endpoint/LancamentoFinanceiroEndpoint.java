package br.com.academiadev.financeiro.endpoint;

import br.com.academiadev.financeiro.model.LancamentoFinanceiro;
import br.com.academiadev.financeiro.repository.LancamentoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class LancamentoFinanceiroEndpoint {

    private LancamentoFinanceiroRepository lancamentoFinanceiroRepository;

    @Autowired
    public LancamentoFinanceiroEndpoint(LancamentoFinanceiroRepository lancamentoFinanceiroRepository) {
        this.lancamentoFinanceiroRepository = lancamentoFinanceiroRepository;
    }

    @GetMapping("/lancamentos_financeiros")
    public List<LancamentoFinanceiro> getLancamentosFinanceiros() {
        return StreamSupport.stream(lancamentoFinanceiroRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @PostMapping("/lancamentos_financeiros")
    public LancamentoFinanceiro create(@RequestBody LancamentoFinanceiro lancamentoFinanceiro) {
        return lancamentoFinanceiroRepository.save(lancamentoFinanceiro);
    }

    @DeleteMapping("/lancamentos_financeiros")
    public void delete(Long idLancamentoFinanceiro) {
        lancamentoFinanceiroRepository.deleteById(idLancamentoFinanceiro);
    }
}
