package edu.vini.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import edu.vini.dominio.conteudo.Conteudo;

public class Bootcamp {
    private LocalDate dataIncial = LocalDate.now();
    private LocalDate dataFinal = dataIncial.plusDays(45L);
    private String nome;
    private String descricao;
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void adicionarConteudo(Conteudo conteudo){
        this.conteudos.add(conteudo);
    }

    public LocalDate getDataIncial() {
        return dataIncial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void atualizarInscritos(){
        List<Dev> list = this.getDevsInscritos()
                .stream()
                .filter(dev -> dev.getConteudosIncritos().isEmpty())
                .toList();
        for(Dev dev: list){
            this.devsInscritos.remove(dev);
        }


    }
    @Override
    public String toString() {
        return "Bootcamp{\n" +
                "dataIncial=" + dataIncial +
                "\n, dataFinal=" + dataFinal +
                "\n, nome='" + nome + '\'' +
                "\n, descricao='" + descricao + '\'' +
                "\n, devsInscritos=" + devsInscritos +
                "\n, conteudos=" + conteudos +
                '}';
    }
}
