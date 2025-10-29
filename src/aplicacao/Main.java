package aplicacao;

import entidades.Funcionario;

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

            System.out.print("Digite o nome do Colaborador: ");
            sc.nextLine();
            nome = sc.nextLine();
            System.out.print("Digite o valor de seu salario: ");
            salario = sc.nextDouble();
            Funcionario fun = new Funcionario(nome, getId, salario);
            f.add(fun);
        }

        Funcionario fu = new Funcionario();

        System.out.print("Deseja aumentar o salario de qual colaborador?: ");
        int idAumentaSal = sc.nextInt();
        int porc;

       for(int i=0; i<f.size(); i++) {
            if (f.contains(idAumentaSal)) {
                System.out.print("Qual a porcentagem de aumento?: ");
                porc = sc.nextInt();
                fu.aumentarSalario(porc);
            } else {
                System.out.println("---------------------------");
                System.out.println("|Erro. Este Id ja existe!!|");
                System.out.println("---------------------------");
                i--;
            }
        }


        for (Funcionario func : f){
            System.out.println(func.getId()+ ", " + func.getNome()+ ", " + func.getSalario());
        }

    sc.close();
    }

}