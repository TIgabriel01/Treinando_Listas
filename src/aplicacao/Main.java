package aplicacao;

import entidades.Funcionario;
import jdk.nashorn.internal.ir.FunctionCall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos Funcionarios serao registrados?: ");
        int n = sc.nextInt();
        int id = 0;
        String nome ;
        double salario;

        List<Funcionario> f = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("============ " + i + " Funcionario: " + "=============");
            System.out.print("Digite o Id: ");
            int getId = sc.nextInt();

            boolean existe = false;
            for (Funcionario func : f){
                if (func.getId() == getId){
                    existe = true;
                    break;
                }
            }
            if (existe){
                    System.out.println("---------------------------");
                    System.out.println("|Erro. Este Id ja existe!!|");
                    System.out.println("---------------------------");
                    i--;
                    continue;
            }

            System.out.print("nome do Colaborador: ");
            sc.nextLine();
            nome = sc.nextLine();
            System.out.print("valor de seu salario: ");
            salario = sc.nextDouble();
            Funcionario fun = new Funcionario(nome, getId, salario);
            f.add(fun);
        }

        Funcionario fu = null;

        while (fu == null) {
            System.out.println();
            System.out.print("Deseja aumentar o salario de qual colaborador?: ");
            int idAumentaSal = sc.nextInt();

            for (Funcionario func : f) {
                if (func.getId() == idAumentaSal) {
                    System.out.print("Qual a porcentagem de aumento?: ");
                    int porc = sc.nextInt();
                    func.aumentarSalario(porc);
                    fu = func;
                    break;
                }
            }
            if (fu == null) {
                System.out.println("---------------------------");
                System.out.println("|Erro. Este Id ja existe!!|");
                System.out.println("---------------------------");
            }
        }
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("Lista de funcionarios:");
        for (Funcionario func : f){
            System.out.println("Id= " + func.getId()+ ", Nome= " + func.getNome()+ ", Salario= " + func.getSalario());
        }

    sc.close();
    }

}