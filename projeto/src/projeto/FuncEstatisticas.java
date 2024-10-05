package projeto;

import java.util.ArrayList;
import java.time.LocalDate;

import myinputs.Ler;



public class FuncEstatisticas {
	
	// ------------------------ ALUNOS ------------------------
	
	public static int menuAluno() {
		int opcaoAluno;
		System.out.println("***********************************************");
		System.out.println("Deseja ver que estatística?");
		System.out.println("  1 - Total de alunos");
		System.out.println("  2 - Nº de alunos inscritos em aulas");
		System.out.println("  3 - Alunos com X anos");
		System.out.println("  4 - Percentagem por Género");
		System.out.println("  5 - Sair");
		System.out.print("***********************************************\n  Opção: ");
		opcaoAluno = Ler.umInt();
		return opcaoAluno;
	}
	
	
	// ---------------- nº de alunos --------------------------
	public static void numAlunos(ArrayList<Curso1> Curso, int num) {
		System.out.println("  A Escola tem um total de [" + Curso.get(num).getAluno().size() + "] alunos");
	}
	
	
	// ---------------- nº de alunos inscritos --------------------------
	public static void alunosInscAula(ArrayList<Curso1> Curso, int num) {
		int num_alunos = 0;
		int num_alunos_total = Curso.get(num).getAluno().size();
		
		for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
			if(Curso.get(num).getAluno().get(i).getAulas().size() > 0) {
				num_alunos++;
			}
		}
		
		if(num_alunos > 0) {
			double percentagem = ((double)num_alunos / (double)num_alunos_total) * 100;
			System.out.println("*********************************************************");
			System.out.println("  O número inscritos é de: " + num_alunos + " Aluno(s)");
			System.out.println("  De um total de " + num_alunos_total + " Aluno(s)");
			System.out.println("  Em percentagem: " + percentagem + "% inscritos");
			
		}
		else {
			System.out.println("  Não tem inscritos nas aulas!");
		}
	}
	
	// ---------------- alunos com X anos --------------------------
	public static void alVerIdade(ArrayList<Curso1> Curso, int num) {
		System.out.println("  Introduza a idade que deseja ver:\n(Por exemplo: 17 -> Mostra os alunos com 17 anos (feitos ou por fazer)");
		int idade = Ler.umInt();
		int num_alunos = 0;
		int num_alunos_total = Curso.get(num).getAluno().size();
		String totalal = "";
		
		for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
			if(Curso.get(num).getAluno().get(i).getDataNasc().getYear() == LocalDate.now().getYear() - idade) {
				num_alunos++;
				totalal += "\n  nº Aluno [" + Curso.get(num).getAluno().get(i).getNum_Aluno() + "] Nome: " + Curso.get(num).getAluno().get(i).getP_nome() + " " + Curso.get(num).getAluno().get(i).getU_nome();
			}
		}
		
		if(num_alunos > 0) {
			double percentagem = ((double)num_alunos / (double)num_alunos_total) * 100;
			System.out.println("*********************************************************");
			System.out.println("O número de alunos com " + idade + " ano(s) é de: " + num_alunos + " Aluno(s)");
			System.out.println("De um total de " + num_alunos_total + " Aluno(s)");
			System.out.println("Em percentagem: " + percentagem + "%");
			System.out.println("Os alunos são:" + totalal);
			
			
		}
		else {
			System.out.println("  Não tem alunos com " + idade + " ano(s)!");
		}
	}
	
	
	
	// ---------------- nº de alunos inscritos por GÉNERO --------------------------
		public static void alunosGenero(ArrayList<Curso1> Curso, int num) {
			int num_alunos = 0;
			int num_alunos_total = Curso.get(num).getAluno().size();
			
			for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
				if(Curso.get(num).getAluno().get(i).getSexo() == 'F' || Curso.get(num).getAluno().get(i).getSexo() == 'f') {
					num_alunos++;
				}
			}
			
			if(num_alunos_total > 0) {
				double percentagemF = ((double)num_alunos / (double)num_alunos_total) * 100;
				double percentagemM = ((double)(num_alunos_total - num_alunos) / (double)num_alunos_total) * 100;
				System.out.println("*********************************************************");
				System.out.println("  O número de alunos do sexo Feminino é de: " + num_alunos + " Aluno(s)");
				System.out.println("  O número de alunos do sexo Masculino é de: " + (num_alunos_total - num_alunos) + " Aluno(s)");
				System.out.println("  De um total de " + num_alunos_total + " Aluno(s)");
				System.out.println("  Em percentagem: " + percentagemF + "% alunos femininos");
				System.out.println("  Em percentagem: " + percentagemM + "% alunos masculinos");
				}
			else {
				System.out.println("  Não tem alunos!");
			}
		}
	
	
	// ------------------------ PROFESSORES ------------------------
	
	public static int menuProfessores() {
		int opcaoProfessores;
		System.out.println("*********************************************");
		System.out.println("Deseja ver que estatística?");
		System.out.println("  1 - Total de Professores");
		System.out.println("  2 - Professores com X anos");
		System.out.println("  3 - Nº de Professores que dá pelo menos 1 aula");
		System.out.println("  4 - Percentagem por Género");
		System.out.println("  5 - Voltar");
		System.out.print("*********************************************\n  Opção: ");
		opcaoProfessores = Ler.umInt();
		return opcaoProfessores;
	}
	
	// ---------------- nº de Professores --------------------------
	public static void numProfessores(ArrayList<Curso1> Curso, int num) {
		System.out.println("  A Escola tem um total de [" + Curso.get(num).getProf().size() + "] Professores");
	}
		
	// ---------------- Professores com X anos --------------------------
	public static void idadeProfessores(ArrayList<Curso1> Curso, int num) {
		System.out.println("  Introduza a idade que deseja ver:\n(Por exemplo: 28 (anos) -> Mostra os Professores com 28 anos (feitos ou por fazer)");
		int idade = Ler.umInt();
		int num_Professores = 0;
		int num_Professores_total = Curso.get(num).getProf().size();
		String totalProfessores = "";
		
		for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
			if(Curso.get(num).getProf().get(i).getDataNasc().getYear() == LocalDate.now().getYear() - idade) {
				num_Professores++;
				totalProfessores += "\n  nº Professores [" + Curso.get(num).getProf().get(i).getNum_Prof() + "] Nome: " + Curso.get(num).getProf().get(i).getP_nome() + " " + Curso.get(num).getProf().get(i).getU_nome();
			}
		}
		
		if(num_Professores > 0) {
			double percentagem = ((double)num_Professores / (double)num_Professores_total) * 100;
			System.out.println("*********************************************************");
			System.out.println("O número de Professores com " + idade + " ano(s) é de: " + num_Professores + " Professores(s)");
			System.out.println("De um total de " + num_Professores_total + " Professores(s)");
			System.out.println("Em percentagem: " + percentagem + "%");
			System.out.println("Os Professores são:" + totalProfessores);
			
			
		}
		else {
			System.out.println("Não tem Professores com " + idade + " ano(s)!");
		}
	}
	
	// ---------------- Professores que dá pelo menos 1 aula --------------------------
	public static void aulasProfessores(ArrayList<Curso1> Curso, int num) {
		int num_Professores = 0;
		int num_Professores_total = Curso.get(num).getProf().size();
		String totalProfessores = "";
		
		for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
			if(Curso.get(num).getProf().get(i).getProfaula().size() >= 1) {
				num_Professores++;
				totalProfessores += "\nnº Professores [" + Curso.get(num).getProf().get(i).getNum_Prof() + "] Nome: " + Curso.get(num).getProf().get(i).getP_nome() + " " + Curso.get(num).getProf().get(i).getU_nome();
			}
		}
		
		if(num_Professores > 0) {
			double percentagem = ((double)num_Professores / (double)num_Professores_total) * 100;
			
			System.out.println("O número de Professores que dá pelo menos 1 aula é de: " + num_Professores + " Professores(s)");
			System.out.println("De um total de " + num_Professores_total + " Professores(s)");
			System.out.println("Em percentagem: " + percentagem + "%");
			System.out.println("Os Professores são:" + totalProfessores);
			
			
		}
		else {
			System.out.println("Não existe Professores que dê pelo menos 1 aula");
		}
	}
	
	// ---------------- Professores percentagem género --------------------------
	public static void generoProfessores(ArrayList<Curso1> Curso, int num) {
		int num_Professores = 0;
		int num_Professores_total = Curso.get(num).getProf().size();
		
		for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
			if(Curso.get(num).getProf().get(i).getSexo() == 'F' || Curso.get(num).getProf().get(i).getSexo() == 'f') {
				num_Professores++;
			}
		}
		
		if(num_Professores_total > 0) {
			double percentagemF = ((double)num_Professores / (double)num_Professores_total) * 100;
			double percentagemM = ((double)(num_Professores_total - num_Professores) / (double)num_Professores_total) * 100;
			System.out.println("*********************************************************");
			System.out.println("  O número de Professores do sexo Feminino é de: " + num_Professores + " Professores");
			System.out.println("  O número de Professores do sexo Masculino é de: " + (num_Professores_total - num_Professores) + " Professores");
			System.out.println("  De um total de " + num_Professores_total + " Aluno(s)");
			System.out.println("  Em percentagem: " + percentagemF + "% Professores femininos");
			System.out.println("  Em percentagem: " + percentagemM + "% Professores masculinos");
			}
		else {
			System.out.println("  Não tem Professores!");
		}
	}
		
		
	
	
	// ------------------------ AULA ------------------------
	
	public static int menuAula() {
		int opcaoaula;
		System.out.println("*************************************");
		System.out.println("  Deseja ver que estatística?");
		System.out.println("  1 - Total de Aulas");
		System.out.println("  2 - Dia de semana com mais aulas"); //f
		System.out.println("  3 - Sair");
		System.out.print("*************************************\n  Opção: ");
		opcaoaula = Ler.umInt();
		return opcaoaula;
	}
	
	// ---------------- dia de semana com mais aulas --------------------------
		public static void aulasDias(ArrayList<Curso1> Curso, int num) {
			String[] dia = {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo"};
			int[] contdia = {0,0,0,0,0,0,0};
				for(int i = 0; i < Curso.get(num).getAula().size(); i++) {
					if(Curso.get(num).getAula().get(i).getDia() == dia[0]) {
						contdia[0]++;
					}
					else if(Curso.get(num).getAula().get(i).getDia().equals(dia[1])) {
						contdia[1]++;
					}
					else if(Curso.get(num).getAula().get(i).getDia().equals(dia[2])) {
						contdia[2]++;
					}
					else if(Curso.get(num).getAula().get(i).getDia().equals(dia[3])) {
						contdia[3]++;
					}
					else if(Curso.get(num).getAula().get(i).getDia().equals(dia[4])) {
						contdia[4]++;
					}
					else if(Curso.get(num).getAula().get(i).getDia().equals(dia[5])) {
						contdia[5]++;
					}
					else if(Curso.get(num).getAula().get(i).getDia().equals(dia[6])) {
						contdia[6]++;
					}
				}
				
				int max = 0;
				int maxletra = 0;
				for(int j = 0; j < contdia.length; j++) {
					if(contdia[j] > max) {
						max = contdia[j];
						maxletra = j;
					}
				}
				
				int totalcont = 0;
				
				for(int l = 0; l < 7; l++) {
					totalcont += contdia[l];
				}	
				
				System.out.println("  O dia de semana com mais aulas é: " + dia[maxletra] + ", com " + max + " aula(s)");
				
				
			}
	
		// ---------------- total de aulas --------------------------
		public static void aulasTotal(ArrayList<Curso1> Curso, int num) {
			if(Curso.get(num).getAula().size() == 0) {
				System.out.println(" Não há aulas!");
			}
			else {
				System.out.println("  O número de aulas é: " + Curso.get(num).getAula().size());
			}
			
		}
			
		
}