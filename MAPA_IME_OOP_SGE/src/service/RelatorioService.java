package service;

import interfaces.Relatorio;

import java.util.List;

public class RelatorioService {

    public String gerarRelatoriosMultiplos(List<Relatorio> entidades) {
        StringBuilder sb = new StringBuilder();
        sb.append("### Início da Geração de Relatórios ###\n");
        for (Relatorio entidade : entidades) {
            sb.append("----------------------------------------\n");
            sb.append(entidade.gerarRelatorio()).append("\n");
        }
        sb.append("----------------------------------------\n");
        sb.append("### Fim da Geração de Relatórios ###\n");
        return sb.toString();
    }
}
