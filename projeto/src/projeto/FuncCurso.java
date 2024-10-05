package projeto;

import java.io.*;
import java.util.ArrayList;

import myinputs.Ler;

public class FuncCurso {

    
     // ------------------- CRIAR CURSO --------------------------------------- 
	
	
    public static void criarCurso(ArrayList<Curso1> Curso) {
        System.out.print("Insira o nome do curso: ");
        String nome = Ler.umaString();

        // Verificar se existe um curso com o mesmo nome
        int cont1 = 1;
        while (cont1 == 1) {
            for (int i = 0; i < Curso.size(); i++) {
                if (Curso.get(i).getNome().equals(nome)) {
                    System.out.println("Um curso com esse nome já existe!");
                    System.out.print("Insira o nome do curso: ");
                    nome = Ler.umaString();
                    cont1++;
                }
            }
            if (cont1 == 1) {
                cont1 = 0;
            } else {
                cont1 = 1;
            }
        }

        Curso1 c1 = new Curso1(nome);
        Curso.add(c1);

        try {
		      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("escola.md"));

		      // escrever o objeto (no ficheiro
		      os.writeInt(Curso1.getUltimo());
		      os.writeObject(Curso);
		      os.flush();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }

    
     // ------------------- CONSULTAR CURSO ESPECÍFICO ------------------------ 
      
      
    public static int consultarCurso(ArrayList<Curso1> cursos) {
        int escolha = 0;
        int cursoNum = -1;
        do {
            System.out.println("*************************************");
            System.out.println("Deseja consultar o curso dado:\n1 - Nome\n2 - Número\n3 - Voltar");
            System.out.print("*************************************\nOpção: ");
            escolha = Ler.umInt();

            switch (escolha) {
                case 1:
                    System.out.println("Insira o nome do curso: ");
                    String nome = Ler.umaString();

                    // Verificar se existe o curso
                    for (int i = 0; i < cursos.size(); i++) {
                        if (cursos.get(i).getNome().equals(nome)) {
                            System.out.println(cursos.get(i).toString());
                            cursoNum = i;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Insira o número do curso: ");
                    int num = Ler.umInt();

                    // Verificar se existe o curso
                    for (int i = 0; i < cursos.size(); i++) {
                        if (cursos.get(i).getNum() == num) {
                            System.out.println(cursos.get(i).toString());
                            cursoNum = i;
                        }
                    }
                    break;

                case 3:
                    System.out.println("A sair...");
                    escolha = 2;
                    break;

                default:
                    System.out.println("Opção errada! Tente novamente!");
            }
        } while (escolha != 1 && escolha != 2);

        return cursoNum;
    }

    
     // ------------------- ALTERAR CURSO ------------------------------------- 
    
    
    public static void alterarCurso(ArrayList<Curso1> Curso) {
        boolean verif2 = false;

        System.out.println("Insira o nome do curso que pretende alterar");
        String nome = Ler.umaString();

        // Verificar se existe o curso com o nome dado
        for (int i = 0; i < Curso.size(); i++) {
            if (Curso.get(i).getNome().equals(nome)) {
                verif2 = true;
                int escolha = 1;

                do {
                    System.out.println("*************************************");
                    System.out.println("O que pretende alterar?\n1 - Nome\n2 - Voltar");
                    System.out.print("*************************************\nOpção: ");
                    escolha = Ler.umInt();

                    switch (escolha) {
                        // Alterar nome
                        case 1:
                            int escNome = 1;
                            while (escNome != 0) {
                                System.out.println("Insira o novo nome");
                                String nomeNovo = Ler.umaString();

                                for (int j = 0; j < Curso.size(); j++) {
                                    if (Curso.get(i).getNome().equals(nomeNovo)) {
                                        System.out.println("O nome que pretende introduzir já existe!");
                                        return;
                                    }
                                }
                                escNome = 0;
                            }
                            break;

                        // Voltar
                        case 2:
                            break;

                        default:
                            System.out.println("Opção errada! Tente novamente!");
                    }
                } while (escolha != 2);
            }

            if (!verif2) {
                System.out.println("Não existe nenhum curso com esse nome");
            }
        }

        try {
		      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("escola.md"));

		      // escrever o objeto (no ficheiro
		      os.writeInt(Curso1.getUltimo());
		      os.writeObject(Curso);
		      os.flush();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }

    
     // ------------------- APAGAR CURSO -------------------------------------- 
     
    
    public static void apagarCurso(ArrayList<Curso1> Curso) {
        int apagar = 1;

        do {
            System.out.println("Insira o nº do curso que pretende apagar: ");
            int num = Ler.umInt();

            for (int i = 0; i < Curso.size(); i++) {
                if (Curso.get(i).getNum() == num) {
                    System.out.println("Deseja apagar o seguinte curso?\n" + Curso.get(i).getNome() +
                            "\n1 - Sim\n2 - Não");
                    apagar = Ler.umInt();

                    switch (apagar) {
                        case 1:
                            Curso.remove(i);
                            System.out.println("Curso removido com sucesso!");
                            apagar = 2;
                            break;

                        case 2:
                            break;

                        default:
                            System.out.println("Opção errada! Tente novamente!");
                    }
                }
            }
        } while (apagar != 2);

        // Escrever os Curso no arquivo
        try {
		      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("escola.md"));

		      // escrever o objeto (no ficheiro
		      os.writeInt(Curso1.getUltimo());
		      os.writeObject(Curso);
		      os.flush();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }

    
     // ------------------- LISTAR CURSO -------------------------------------- 
     
    
    public static void listarCurso(ArrayList<Curso1> Curso) {
        String listar = "";

        for (int i = 0; i < Curso.size(); i++) {
            listar += "\n" + Curso.get(i).toString();
        }

        System.out.println(listar);
    }
}
