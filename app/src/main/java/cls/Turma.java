package cls;

import java.util.Date;

public class Turma{

    private String horaInicio;
    private String horaTermino;
    private String instrutor;
    private String nome;

    public Turma(String horaInicio, String horaTermino, String instrutor, String nome) {
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.instrutor = instrutor;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
