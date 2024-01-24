package edu.vini.dominio.conteudo;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class Mentoria extends Conteudo{
    private final LocalDate data = LocalDate.now() ;
    @Override
    public double calcularXp() {
        return Conteudo.XP_PADRAO + 10;
    }
    public LocalDate getData() {
        return data;
    }
    @Override
    public String toString() {
        return "Mentoria{" +
                "Titulo=" + this.getTitulo() +
                ", Descricao=" + this.getDescricao() +
                ", Data=" + data +
                '}';
    }
}
