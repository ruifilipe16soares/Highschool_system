package projeto;

import java.io.*;
import java.util.ArrayList;
import java.time.DateTimeException;
import java.time.LocalDate;

import myinputs.Ler;

public class FuncAluno {
	
	// ------------------- CRIAR ALUNO ---------------------------------------- 
	 
	 
	public static void criarAluno(ArrayList<Curso1> Curso, int num) {
		boolean verificar = true;
	
		System.out.println("Insira o primeiro nome: ");
		String p_nome = Ler.umaString();
		
		System.out.println("Insira o último nome: ");
		String u_nome = Ler.umaString();
		
		System.out.println("Insira o NIF: ");
		int nif = Ler.umInt();
		int cont1 = 1;
		while(cont1 == 1) {
			for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
				if(Curso.get(num).getAluno().get(i).getNif() == nif) {
					System.out.println("O NIF [" + nif + "] já está registado no sistema!");
					System.out.println("Insira o NIF: ");
					nif = Ler.umInt();
					cont1++;
				}
			}
			if(cont1 == 1) {
				cont1 = 0;
			}
			else {
				cont1 = 1;
			}
		}
		char sexo = 'A';
		while(sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f') { 
			System.out.println("Insira o seu sexo (M ou F)");
			sexo = Ler.umChar();
		}
	
			
		int dia = 1, mes = 1, ano = 1;
		
		
		Pessoa pax = new Pessoa(p_nome, u_nome, nif, dia, mes, ano, sexo);
		
		System.out.println("Insira a sua data de nascimento ");
		verificar = true;
		while(verificar) {
			try {
				System.out.println("Ano: ");
				ano = Ler.umInt();
				System.out.println("Mês (1-12): ");
				mes = Ler.umInt();
				System.out.println("Dia: ");
				dia = Ler.umInt();
				pax.setDataNasc(ano, mes, dia);
				verificar = false;
			}
			catch(DateTimeException d) {
				System.out.println("Valores errados! Tente novamente! (Lembre-se: Meses de 1 a 12!)");
			}
		}
		Aluno mem = new Aluno(pax);
		
		mem.setNum_Aluno(Curso.get(num).getAluno().size() + 1);
		
		for(int j = 0; j < Curso.get(num).getAluno().size(); j++) {
			if(mem.getNum_Aluno() == Curso.get(num).getAluno().get(j).getNum_Aluno()) {
				mem.setNum_Aluno(mem.getNum_Aluno() + 1);
			}
		}
		
		// turmas
		System.out.println("*************************************************************\nCursos:\n  1 - Cientificas");
		System.out.println("  2 - Humanidades");
		System.out.println("  3 - Economias\n*************************************************************\n");

		System.out.println("Escolha o curso (1, 2 ou 3): ");
		int escolhaCurso = Ler.umInt();
		String turma = "";
		String horario = "";
		
		// Assuming mem.getDataNasc().getYear() represents the birth year of the member --LocalDATE utilizado
		int idadeAluno = LocalDate.now().getYear() - mem.getDataNasc().getYear();

		if (idadeAluno == 16) {
		    if (escolhaCurso == 1) {
		        turma = "10A";
		        horario = "	\r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h  |Mat|   |E.F|	|Mat|   |F.Q|   |E.F|	\r\n"
		        		+ "\r\n"
		        		+ "11h-13h |Prt|            |Ing|           |F.Q| \r\n"
		        		+ "\r\n"
		        		+ "13h-14h   -------------Almoco------------------ \r\n"
		        		+ "\r\n"
		        		+ "14h-16h         |Ing|    |Prt|\r\n"
		        		+ "\r\n"
		        		+ "16h-18h"
		        		+ "\r\n";
		    } else if (escolhaCurso == 2) {
		        turma = "10B";
		        horario = "	\r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h  |Prt|            |E.F|   |His|   |Ing| \r\n"
		        		+ "\r\n"
		        		+ "11h-13h |His|            |Geo|   |Geo|         \r\n"
		        		+ "\r\n"
		        		+ "13h-14h	  -------------Almoco----------------- \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |Ing|   |Prt|\r\n"
		        		+ "\r\n"
		        		+ "16h-18h         |E.F|\r\n"
		        		+ "\r\n";
		    } else if (escolhaCurso == 3) {
		        turma = "10C";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h          |Ecn|    |Ecn|   |Ing|         \r\n"
		        		+ "\r\n"
		        		+ "11h-13h |Mat|   |Prt|                    |Prt| \r\n"
		        		+ "\r\n"
		        		+ "13h-14h   -------------Almoco------------------ \r\n"
		        		+ "\r\n"
		        		+ "14h-16h                  |Mat|                \r\n"
		        		+ "\r\n"
		        		+ "16h-18h |E.F|   |Ing|    |E.F|\r\n"
		        		+ "\r\n";
		    }
		} else if (idadeAluno == 17) {
		    if (escolhaCurso == 1) {
		        turma = "11A";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h          |Mat|    |Prt|   |E.F|   |Ing| \r\n"
		        		+ "\r\n"
		        		+ "11h-13h |Mat|   |F.Q|                    |Prt| \r\n"
		        		+ "\r\n"
		        		+ "13h-14h  -------------Almoco------------------  \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |Ing|            |E.F|\r\n"
		        		+ "\r\n"
		        		+ "16h-18h |F.Q|  \r\n"
		        		+ "\r\n";
		    } else if (escolhaCurso == 2) {
		        turma = "11B";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h  |Geo|   |Prt|    |Prt|   |His|    \r\n"
		        		+ "\r\n"
		        		+ "11h-13h         |E.F|    |His|   |Geo|    \r\n"
		        		+ "\r\n"
		        		+ "13h-14h  -------------Almoco------------------  \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |E.F|   |Ing|            |Ing| \r\n"
		        		+ "\r\n"
		        		+ "16h-18h\r\n"
		        		+ "\r\n";
		    } else if (escolhaCurso == 3) {
		        turma = "11C";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h  |E.F|                    |Ecn|   |Ecn| \r\n"
		        		+ "\r\n"
		        		+ "11h-13h         |E.F|    |Prt|   |Mat|   |Ing| \r\n"
		        		+ "\r\n"
		        		+ "13h-14h  -------------Almoco------------------  \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |Prt|   |Ing|    |Mat|\r\n"
		        		+ "\r\n"
		        		+ "16h-18h\r\n"
		        		+ "\r\n";
		    }
		} else if (idadeAluno == 18) {
		    if (escolhaCurso == 1) {
		        turma = "12A";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h  |Ing|            |Mat|   |F.Q|   |E.F| \r\n"
		        		+ "\r\n"
		        		+ "11h-13h |Prt|  |Prt|                   |Mat|\r\n"
		        		+ "\r\n"
		        		+ "13h-14h  -------------Almoco------------------  \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |F.Q|  \r\n"
		        		+ "\r\n"
		        		+ "16h-18h        |E.F|             |Ing|\r\n"
		        		+ "\r\n";
		    } else if (escolhaCurso == 2) {
		        turma = "12B";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h          |Prt|            |Ing|         \r\n"
		        		+ "\r\n"
		        		+ "11h-13h |His|            |His|           |Geo|\r\n"
		        		+ "\r\n"
		        		+ "13h-14h  -------------Almoco------------------  \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |Geo|   |Ing|                    |His|\r\n"
		        		+ "\r\n"
		        		+ "16h-18h                  |E.F|   |E.F| \r\n"
		        		+ "\r\n";
		    } else if (escolhaCurso == 3) {
		        turma = "12C";
		        horario = " \r\n"
		        		+ "________ Seg ___ Ter ____ Qua ___ Qui ___ Sex  \r\n"
		        		+ "	\r\n"
		        		+ "9h-11h  \r\n"
		        		+ "\r\n"
		        		+ "11h-13h |Prt|   |Ing|    |Ecn|   |Ing|         \r\n"
		        		+ "\r\n"
		        		+ "13h-14h  -------------Almoco------------------  \r\n"
		        		+ "\r\n"
		        		+ "14h-16h |Mat|   |Ecn|  |Mat|             |Prt|\r\n"
		        		+ "\r\n"
		        		+ "16h-18h                          |E.F|   |E.F|\r\n"
		        		+ "\r\n";
		    }
		} else {
		    System.out.println("Não há turma disponível para a sua idade e escolha de curso.");
		    return; // Sair da função
		}

		System.out.println("Turma: " + turma);
		mem.setTurma(turma);
		
		System.out.println("Horário: " + horario);
		mem.setHorario(horario);

		
		
		Curso.get(num).addAluno(mem);
		
		// ESCRITA PARA O FICHEIRO DAS CursoS (alterar ficheiro)
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
	
	// ------------------- LISTAR ALUNOS -------------------------------------- 
	
	
	public static void listarAluno(ArrayList<Curso1> Curso, int num) {
		String s = "";
		for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
			s += "\n" + Curso.get(num).getAluno().get(i).toString();
		}
		System.out.println(s);
	}
	
	
	// ------------------- CONSULTAR ALUNO -------------------------------------- 
	 
	
	public static void consultarAluno(ArrayList<Curso1> Curso, int num) {
		boolean verificar = true;
		int escolha = 1;
		do {
			System.out.println("*************************************");
			System.out.println("Deseja consultar dado:\n  1 - Nome\n  2 - Número de Aluno\n  3 - NIF\n  4 - Voltar");
			System.out.print("*************************************\n  Opção:");
			escolha = Ler.umInt();
			switch(escolha) {
			
			// dado o nome
			case 1: verificar = true;
					do {
						System.out.println("  Insira o primeiro nome: ");
						String totalnome = "";
						String p_nome = Ler.umaString();
						System.out.println("  Insira o último nome: ");
						String u_nome = Ler.umaString();
						for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
							if(Curso.get(num).getAluno().get(i).getP_nome().equals(p_nome) && Curso.get(num).getAluno().get(i).getU_nome().equals(u_nome)) {
								totalnome = Curso.get(num).getAluno().get(i).toString();
							}
						}
						if(totalnome.equals("")) {
							System.out.println("  Não existe nenhum Aluno registado com esse nome!");
						}
						else {
							System.out.println(totalnome);
							verificar = false;
						}
				} while(verificar);
			break;
			
			// dado o número de Aluno
			case 2: System.out.println("  Insira o número de Aluno: ");
					String totalnum = "";
					int numm = Ler.umInt();
					
					for(int j = 0; j < Curso.get(num).getAluno().size(); j++) {
						if(numm == Curso.get(num).getAluno().get(j).getNum_Aluno()) {
							totalnum = Curso.get(num).getAluno().get(j).toString();
						}
					}
					
					if(totalnum.equals("")) {
						System.out.println("  Não existe nenhum Aluno registado com esse número!");
					}
					else {
						System.out.println(totalnum);
					}
			break;
			
			// dado o nif
			case 3: System.out.println("  Insira o NIF: ");
					String totalnif = "";
					int nif = Ler.umInt();
					
					for(int k = 0; k < Curso.get(num).getAluno().size(); k++) {
						if(nif == Curso.get(num).getAluno().get(k).getNif()) {
							totalnif = Curso.get(num).getAluno().get(k).toString();
						}
					}
					
					if(totalnif.equals("")) {
						System.out.println("  Não existe nenhum Aluno registado com esse NIF!");
					}
					else {
						System.out.println(totalnif);
					}
			break;
			}
		} while(escolha != 4);
	}
	
	
	// ------------------- ALTERAR ALUNO -------------------------------------- 
	 
	
	
	public static void alterarAluno(ArrayList<Curso1> Curso, int num) {
		boolean verificar = true;
		
		System.out.println("  Insira o número do Aluno que pretende alterar");
		int numm = Ler.umInt();
		
		for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
			if(Curso.get(num).getAluno().get(i).getNum_Aluno() == numm) {
				int escolha = 1;
				do {
					System.out.println("*************************************");
					System.out.println("O que pretende alterar:\n  1 - Nome\n  2 - NIF\n  3 - Data de Nascimento\n  4 - Sexo\n  5 - Voltar");
					System.out.print("*************************************\n  Opção:");
					escolha = Ler.umInt();
					switch(escolha) {
					
					// --------------- mudar o nome ------------------
					case 1: int escnome = 1;
							do {
								System.out.println("*************************************");
								System.out.println("Deseja alterar:\n  1 - Primeiro Nome\n  2 - Último Nome\n  3 - Ambos\n  4 - Voltar");
								System.out.print("*************************************\n  Opção:");
								escnome = Ler.umInt();
								switch(escnome) {
								case 1:	System.out.println("  Insira o novo Primeiro nome: ");
										String p_nome = Ler.umaString();
										
										Curso.get(num).getAluno().get(i).setP_nome(p_nome); // set Primeiro nome
								break;
								
								case 2: System.out.println("  Insira o novo Último nome: ");
										String u_nome = Ler.umaString();
										
										Curso.get(num).getAluno().get(i).setU_nome(u_nome); // set Último nome
								break;
								
								case 3: System.out.println("  Insira o novo Primeiro nome: ");
										String p_nome2 = Ler.umaString();
										System.out.println("  Insira o novo Último nome: ");
										String u_nome2 = Ler.umaString();
										
										Curso.get(num).getAluno().get(i).setP_nome(p_nome2); // set Primeiro nome
										Curso.get(num).getAluno().get(i).setU_nome(u_nome2); // set Último nome
								}
								
							} while(escnome != 4);
					break;
					
					// --------------- mudar o nif ------------------
					case 2:	int escnif = 1;
							while(escnif == 1) {
								System.out.println("  Insira o novo NIF: ");
								int nif = Ler.umInt();
							
								for(int l = 0; l < Curso.get(num).getAluno().size(); l++) {
									if(nif == Curso.get(num).getAluno().get(l).getNif()) {
										System.out.println("  Já existe um NIF igual registado!");
										escnif = 0;
									}
								}
								Curso.get(num).getAluno().get(i).setNif(nif); // set do novo nif
								escnif = 0;	
							}	
					break;
					
					// --------------- mudar a idade ------------------
					case 3:	int escidade = 1;
							do {
								System.out.println("*************************************");
								System.out.println("Deseja alterar:\n  1 - Dia\n  2 - Mês\n  3 - Ano\n  4 - Sair");
								System.out.print("*************************************\n  Opção:");
								escidade = Ler.umInt();
								switch(escidade) {
								
								// novo dia
								case 1:	verificar = true;
										while(verificar) {
											try {
												System.out.println("  Insira o novo dia: ");
												int dia = Ler.umInt();
												Curso.get(num).getAluno().get(i).setDataNasc(Curso.get(num).getAluno().get(i).getDataNasc().getYear(), Curso.get(num).getAluno().get(i).getDataNasc().getMonthValue(), dia);
												verificar = false;
											}
											catch(DateTimeException d) {
												System.out.println("Valor do dia errado!");
											}
										}
								break;
						
								// novo mês
								case 2: verificar = true;
										while(verificar) {
											try {
												System.out.println("  Insira o novo mês (1-12): ");
												int mes = Ler.umInt();
												Curso.get(num).getAluno().get(i).setDataNasc(Curso.get(num).getAluno().get(i).getDataNasc().getYear(), mes, Curso.get(num).getAluno().get(i).getDataNasc().getDayOfMonth());
												verificar = false;
											}
											catch(DateTimeException d) {
												System.out.println("Valor do mês errado! Insira apenas valores de 1 a 12!");
											}
										}
								break;
								
								// novo ano	
								case 3:	verificar = true;
										while(verificar) {
											try {
												System.out.println("  Insira o novo ano (1900 - 2023): ");
												int ano = Ler.umInt();
												Curso.get(num).getAluno().get(i).setDataNasc(ano, Curso.get(num).getAluno().get(i).getDataNasc().getMonthValue(), Curso.get(num).getAluno().get(i).getDataNasc().getDayOfMonth());
												verificar = false;
												}
											catch(DateTimeException d) {
												System.out.println("Valor do ano errado! Insira apenas valores de 1900 a 2023!");
											}
										}
								break;
								
								// sair
								case 4:
								break;
								
								default: System.out.println("  Opção inválida! Tente novamente");
								}
							} while(escidade!= 4);
					break;
					
					// --------------- mudar o sexo --------------------
					case 4: int escsexo = 1;
							char novosexo = 'F';
							while(escsexo == 1) {
								System.out.println("  Género: " + Curso.get(num).getAluno().get(i).getSexo());
								System.out.print("  Insira o novo género (M ou F): ");
								novosexo = Ler.umChar();
								
								if(novosexo != 'M' && novosexo != 'm' && novosexo != 'F' && novosexo != 'f') {
									System.out.println("  Caracter introduzido não permitido, apenas permitido M ou F!");
								}
								else {
									escsexo = 2;
								}
							}
							Curso.get(num).getAluno().get(i).setSexo(novosexo);
					break;
					
					// --------------- sair --------------------
					case 5:
					break;
					
					default: System.out.println("  Opção inválida! Tente novamente");
					}
					
				} while(escolha != 5);
			}
		}
		
		// ESCRITA PARA O FICHEIRO DAS CursoS (alterar ficheiro)
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
	
	
	// ------------------- APAGAR ALUNO --------------------------------------- 
	
	
	public static void apagarAluno(ArrayList<Curso1> Curso, int num) {
		int controlo = 1;
		while(controlo != 3) {
			System.out.println("  Insira o número do Aluno que pretende alterar: ");
			int numem = Ler.umInt();
			
			for(int i = 0; i < Curso.get(num).getAluno().size(); i++) {
				if(numem == Curso.get(num).getAluno().get(i).getNum_Aluno()) {
					int controlo2 = 1;
					do {
						System.out.println("  Deseja remover o seguinte Aluno? \n" + Curso.get(num).getAluno().get(i).toString() + "\n 1 - Sim\n 2- Não");
						controlo2 = Ler.umInt();
						if(controlo2 == 1) { // se 1 - Sim, remove o Aluno e sai
							Curso.get(num).getAluno().remove(i);
							System.out.println("  Aluno removido com sucesso!");
							return;	
						}
						else if(controlo2 == 2) { // se 2 - Não, repete!
							controlo2 = 2;
						}
					} while(controlo2 != 2);
				}
			}
			System.out.println("  Não existe nenhum Aluno com esse número");
		}
		
		// ESCRITA PARA O FICHEIRO DAS CursoS (alterar ficheiro)
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
	
}