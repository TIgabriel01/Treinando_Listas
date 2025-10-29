package entidades;

import java.util.List;

public class Funcionario {
    private String nome;
    private int id;
    private double salario;

    public void aumentarSalario(double valor) {
      salario += salario * (valor / 100);
    }

    public Funcionario() {
    }

    public Funcionario(String nome, int id, double salario) {
        this.nome = nome;
        this.id = id;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
