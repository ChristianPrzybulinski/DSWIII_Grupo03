package cls;

import java.io.Serializable;
import java.util.Date;

public class Turma{

    public String horaInicio;
    public String horaTermino;
    public String instrutor;
    public String nome;

    public Turma(){}

    public Turma(String horaInicio, String horaTermino, String instrutor, String nome) {
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.instrutor = instrutor;
        this.nome = nome;
    }


    public String toString(){
        return "Nome:"+this.nome+ "  Inicio: "+this.horaInicio;
    }
}
