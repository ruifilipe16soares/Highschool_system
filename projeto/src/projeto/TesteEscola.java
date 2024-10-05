/*Trabalho elaborado por:
 * Rui Soares - 46022
 * Leonardo Gonçalves - 48710
 */

package projeto;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import myinputs.Ler; 


public class TesteEscola {
	
	//------------------------MENUS-------------------------
	
	
	// menu4
	public static int menu4() {
		int escolh4;
		System.out.println("****************************************************");
		System.out.println("Qual das seguintes opções deseja ver?");
		System.out.println("  1 - Alunos");
		System.out.println("  2 - Professores");
		System.out.println("  3 - Aulas");
		System.out.println("  4 - Estatísticas");
		System.out.println("  5 - Voltar");
		System.out.println("****************************************************");
		System.out.print("  Opção: ");
		escolh4 = Ler.umInt();
		return escolh4;
	}
	
	// menu3
	public static int menu3() {
		int escolh3;
		System.out.println("****************************************************");
		System.out.println("Deseja ver Alunos, Professores, Aulas, Estatísticas, etc?");
		System.out.println("  1 - Sim");
		System.out.println("  2 - Não");
		System.out.println("****************************************************");
		System.out.print("  Opção: ");
		escolh3 = Ler.umInt();
		return escolh3;
	}
	
	// menu para a classe Curso (principal)
	public static int menu() {
		int opcao;
		System.out.println("\n********************* Menu **********************");
		System.out.println("  1 - Criar Curso");
		System.out.println("  2 - Listar Cursos");
		System.out.println("  3 - Consultar curso pelo nome ou número");
		System.out.println("  4 - Alterar curso");
		System.out.println("  5 - Apagar um curso");
		System.out.println("  6 - Terminar");
		System.out.println("**************************************************");
		System.out.print("  Opção: ");
		opcao = Ler.umInt();
		return opcao;
	}
	
	// menu para a classe Aluno
	public static int menuAluno() {
		int opcaoal;
		System.out.println("\n******************** Alunos *********************");
		System.out.println("  1 - Criar Aluno");
		System.out.println("  2 - Listar Alunos");
		System.out.println("  3 - Consultar Aluno pelo o nome, número ou NIF");
		System.out.println("  4 - Alterar Aluno");
		System.out.println("  5 - Apagar Aluno");
		System.out.println("  6 - Voltar");
		System.out.println("***************************************************");
		System.out.print("  Opção: ");
		opcaoal = Ler.umInt();
		return opcaoal;
	}
	
	// menu para a classe Prof
	public static int menuProf() {
		int opcaoProf;
		System.out.println("\n********************* Professores **********************");
		System.out.println("  1 - Criar Professor");
		System.out.println("  2 - Listar Professor");
		System.out.println("  3 - Consultar Professor pelo nome, NIF, ou número");
		System.out.println("  4 - Alterar Professor");
		System.out.println("  5 - Apagar Professor");
		System.out.println("  6 - Voltar");
		System.out.println("***************************************************");
		System.out.print("  Opção: ");
		opcaoProf = Ler.umInt();
		return opcaoProf;
	}
	
	// menu para a classe Aula
	public static int menuaula() {
		int opcaoaula;
		System.out.println("\n********************** Aulas **********************");
		System.out.println("  1 - Criar Aula");
		System.out.println("  2 - Consultar Aulas");
		System.out.println("  3 - Consultar Aula pelo nome, horas ou código");
		System.out.println("  4 - Inscrever Aluno numa Aula");
		System.out.println("  5 - Remover Aluno de uma Aula");
		System.out.println("  6 - Atribuir Professor a uma Aula");
		System.out.println("  7 - Remover Professor de uma Aula");
		System.out.println("  8 - Alterar Aula");
		System.out.println("  9 - Apagar Aula");
		System.out.println("  10 - Voltar");
		System.out.println("*****************************************************");
		System.out.print("  Opção: ");
		opcaoaula = Ler.umInt();
		return opcaoaula;
	}
	
	public static int menuEstatisticas() {
		int opcaostat;
		System.out.println("\n****************** Estatísticas ******************");
		System.out.println("  1 - Alunos");
		System.out.println("  2 - Professores");
		System.out.println("  3 - Aulas");
		System.out.println("  4 - Voltar");
		System.out.println("****************************************************");
		System.out.print("Opção: ");
		opcaostat = Ler.umInt();
		return opcaostat;
	}
	
	
	//-------------------------MAIN-------------------------------------
	
	
	public static void main(String[] args) {
	    int escolha, escolha2, escolha3, escolha4;

	    // ArrayList dos Cursos (todos)
	    ArrayList<Curso1> cursos = new ArrayList<Curso1>();
		
		// Ler ficheiro
		try {
	
			ObjectInputStream is = new ObjectInputStream( new FileInputStream("escola.md"));
			int ult = is.readInt();
			Curso1.setUltimo(ult);
			cursos = (ArrayList<Curso1>) is.readObject();
			is.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException c) {
			System.out.println(c.getMessage());
		}
	
	
		System.out.println("                 _ _.-^-._ _\r\n"
				+ "                /.-________-./\r\n"
				+ "     _________/.[____________]./___________\r\n"
				+ "    |          ||E S C O L A||            |\r\n"
				+ "    |         S E C U N D Á R I A         |\r\n"
				+ "    |_ _ _ _ _  _  _  _  _  _  _  _  _  _ |\r\n"
				+ "    |-- ||--||--C O V I L H Ã --||-- ||--||\r\n"
				+ "    |_ _ _ _ _  _  _  _  _  _  _  _  _  _ |\r\n"
				+ " **********************************************\r\n"
				+ " **************Seja----bem---vindo*************\r\n"
				+ "************************************************");
		
		do {
			escolha = menu();
			switch(escolha) {
			
			// -------------------------- criar Curso --------------------------
			
			case 1: FuncCurso.criarCurso(cursos);
			break;
			
			// -------------------------- listar Cursos --------------------------
			
			case 2: FuncCurso.listarCurso(cursos); // o toString é dado automaticamente, mas o efeito é de Cursos.toString()
			break;
			
			// -------------------------- consultar um Curso --------------------------
			
			case 3: int numcurso = FuncCurso.consultarCurso(cursos); // consultar o Curso dado o nome, também dará a opçao de vermos os Alunos, aulas, Prof, etc...
					do {
						escolha2 = menu3(); // mostra o menu a perguntar se o utilizar quer ver as opçoes de Aluno, Prof, etc...
						switch(escolha2) {
						
						case 1:  do {
									escolha3 = menu4(); // mostra o menu com as opções de Aluno, Prof, etc...
									switch(escolha3) {
									
									// --------- opções dos Alunos ------------------
									case 1: escolha4 = 1;
								     			do {
												escolha4 = menuAluno();
												switch(escolha4) {
												
												// ------ criar Aluno ----------
												case 1: FuncAluno.criarAluno(cursos, numcurso);
												break;
												
												// ------ listar Alunos ----------
												case 2: FuncAluno.listarAluno(cursos, numcurso);
												break;
												
												// ------ consultar Aluno dado nome ou nº ou nif ----------
												case 3: FuncAluno.consultarAluno(cursos, numcurso);
												break;
												
												// ------ alterar Aluno ----------
												case 4: FuncAluno.alterarAluno(cursos, numcurso);
												break;
												
												// ------ apagar Aluno ----------
												case 5: FuncAluno.apagarAluno(cursos, numcurso);
												break;
												
												// ------ sair ----------
												case 6:	System.out.println("A voltar...");
												break;
												
												default: System.out.println("Opção inválida! Tente novamente");
												}
											} while(escolha4 != 6);
									break;
									
									// --------- opções dos Prof ------------------
									case 2: escolha4 = 1;
											do {
												escolha4 = menuProf();
												switch(escolha4) {
												
												// ------ criar Prof ----------
												case 1: FuncProf.criarProf(cursos, numcurso);
												break;
												
												// ------ listar Prof ----------
												case 2:	FuncProf.listarProf(cursos, numcurso);
												break;
												
												// ------ consultar Prof, dado nome, etc... ----------
												case 3:	FuncProf.consultarProf(cursos, numcurso);
												break;
												
												// ------ alterar Prof ----------
												case 4:	FuncProf.alterarProf(cursos, numcurso);
												break;
												
												// ------ apagar Prof ----------
												case 5:	FuncProf.apagarProf(cursos, numcurso);
												break;
												
												// ------ sair ---------
												case 6:	System.out.println("A sair...");
												break;
												
												}
											} while(escolha4 != 6);
									break;
									
									// --------- opções das aulas ------------------
									case 3: escolha4 = 1;
											do {
												escolha4 = menuaula();
												switch(escolha4) {
												
												// ------ criar aula ----------
												case 1: FuncAula.criarAula(cursos, numcurso);
												break;
												
												// ------ listar aula ----------
												case 2: FuncAula.listarAula(cursos, numcurso);
												break;

												// ------ consultar aula, dado codigo, etc... ----------
												case 3:	FuncAula.consultarAula(cursos, numcurso);
												break;
												
												// ------ inscrever Aluno ----------
												case 4: FuncAula.inscreverAula(cursos, numcurso);
												break;
												
												// ------ remover Aluno -----------
												case 5: FuncAula.removerAluno(cursos, numcurso);
												break;
												
												// ------ atribuir Professor ----------
												case 6:	FuncAula.atribuirAula(cursos, numcurso);
												break;
												
												// ------ remover Professor ----------
												case 7: FuncAula.removerProfessor(cursos, numcurso);
												break;
												
												// ------ alterar aula ----------
												case 8: FuncAula.alterarAula(cursos, numcurso);
												break;
												
												// ------ apagar aula ----------
												case 9:	FuncAula.apagarAula(cursos, numcurso);
												break;
												
												// ------ sair ----------
												case 10:	System.out.println("A voltar...");
												break;
												
												default: System.out.println("Opção errada! Tente novamente!");
												}
											} while(escolha4 != 10);
									break;
									
									// --------- opções das estatísticas ------------------
									case 4:	escolha4 = 1;
											do {
												escolha4 = menuEstatisticas();
												int escolha5 = 1;
												switch(escolha4) {
												
												// ------ Alunos ----------
												case 1:	do {
															escolha5 = FuncEstatisticas.menuAluno();
															switch(escolha5) {
															
															// ------ nº total de Alunos ----------
															case 1: FuncEstatisticas.numAlunos(cursos, numcurso);
															break;
															
															// ------ nº de Alunos inscritos em aulas ----------
															case 2:	FuncEstatisticas.alunosInscAula(cursos, numcurso);
															break;
															
															// ------ Alunos com X idade ----------
															case 3: FuncEstatisticas.alVerIdade(cursos, numcurso);
															break;
															
											
															// ------ género em percentagem ----------
															case 4: FuncEstatisticas.alunosGenero(cursos, numcurso);
															break;
															
															// ------ sair ----------
															case 5:	
															break;
															
															default: System.out.println("Opção errada! Tente novamente!");
															}
														} while(escolha5 != 5);
														
												break;
												
												// ------ Prof ----------
												case 2:	do {
														escolha5 = FuncEstatisticas.menuProfessores();
														switch(escolha5) {
														
														// ------ nº total de Prof ----------
														case 1: FuncEstatisticas.numProfessores(cursos, numcurso);
														break;
														

														// ------ Prof com X anos ----------
														case 2:	FuncEstatisticas.idadeProfessores(cursos, numcurso);
														break;
														
														// ------ nº de Prof que dá uma ou mais aulas ----------
														case 3: FuncEstatisticas.aulasProfessores(cursos, numcurso);
														break;
														
														// ------ Prof por género
														case 4:	FuncEstatisticas.generoProfessores(cursos, numcurso);
														break;
														
														// ------ sair ----------
														case 5:	
														break;
														
														default: System.out.println("Opção errada! Tente novamente!");
														}
													} while(escolha5 != 5);
		
												break;
												
												// ------ aulas ----------
												case 3: do {
														escolha5 = FuncEstatisticas.menuAula();
														switch(escolha5) {
														
														// ------ nº de aulas ----------
														case 1:	FuncEstatisticas.aulasTotal(cursos, numcurso);
														break;
														
														// ------ dia de semana ----------
														case 2:	FuncEstatisticas.aulasDias(cursos, numcurso);
														break;
														
														// ------ voltar ----------
														case 3: System.out.println("  A voltar...");
														break;
														
														default: System.out.println("  Opção errada! Tente novamente!");
														}
													} while(escolha5 != 3);
												
												break;
												
												// ------ sair ----------
												case 4:
												break;
												}
											} while(escolha4 != 4);
									break;
									
									// --------- sair ------------------
									case 5: System.out.println("  A voltar...");
											escolha2 = 2;
									break;
									
									default: System.out.println("  Opção errada! Tente novamente!");
									}
							} while(escolha3 != 5);
								
						
						break;
						
						// --------- sair ------------------
						case 2: System.out.println("  A voltar...");
						break;
						
						default: System.out.println("  Opção Errada! Tente novamente!");
						}
							
					} while(escolha2 != 2);
			break;	
			
			// -------------------------- alterar Curso --------------------------
			
			case 4: FuncCurso.alterarCurso(cursos);
			break;
			
			// -------------------------- apagar Curso --------------------------
			
			case 5:	FuncCurso.apagarCurso(cursos);
			break;
			
			// terminar
			case 6:	
			break;
			}
		} while(escolha != 6);
	}
}