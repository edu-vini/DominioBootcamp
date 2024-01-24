package edu.vini.dominio.conteudo;

public class Curso extends Conteudo{
    private int cargaHoraria;
    public Curso(){
    }
    @Override
    public double calcularXp() {
        return Conteudo.XP_PADRAO * this.cargaHoraria;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Titulo=" + this.getTitulo() +
                ", Descricao=" + this.getDescricao() +
                ", cargaHoraia=" + cargaHoraria +
                '}';
    }
}
