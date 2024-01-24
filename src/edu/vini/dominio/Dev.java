package edu.vini.dominio;

import edu.vini.dominio.conteudo.Conteudo;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosIncritos = new HashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosIncritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosIncritos.stream()
                .findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosIncritos.remove(conteudo.get());
        } else {
            System.err.println(this.getNome() + " não está inscrito(a) em nenhum conteúdo!");
        }
    }
    public double calcularTotalXp(){
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public Set<Conteudo> getConteudosIncritos() {
        return conteudosIncritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dev otherDev = (Dev) object;
        return Objects.equals(this.nome, otherDev.nome); // Substitua 'id' pelo campo de identificação do Dev
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", conteudosIncritos=" + conteudosIncritos.size() +
                ", conteudosConcluidos=" + conteudosConcluidos.size() +
                '}';
    }
}
