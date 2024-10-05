package projeto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import myinputs.Ler;

public class FuncAula {

	
	 // ------------------- CRIAR AULA ------------------------------------------ 
	 
	
	public static void criarAula(ArrayList<Curso1> Curso, int num) {
		int cont1 = 1;

		System.out.println("  Insira o nome da Aula: ");
		String nome = Ler.umaString();

		System.out.println("  Insira o código da aula");
		int codigo = Ler.umInt();

		while (cont1 == 1) {
			for (int j = 0; j < Curso.get(num).getAula().size(); j++) {
				if (Curso.get(num).getAula().get(j).getCodigo() == codigo) {
					System.out.println(
							"  Já existe um aula com esse código -> " + Curso.get(num).getAula().get(j).getNome());
					System.out.println("  Insira o código da aula");
					codigo = Ler.umInt();
					cont1++;
				}
			}
			if (cont1 == 1) {
				cont1 = 0;
			} else {
				cont1 = 1;
			}
		}

		int diacount = 1;
		String dia = "";
		do {
			System.out.println(
					"  Escolha o dia de semana em que se vai realizar a aula:\n  1 - Segunda-Feira\n  2 - Terça-Feira\n  3 - Quarta-Feira\n  4 - Quinta-Feira\n  5 - Sexta-Feira\n");
			int diaesc = Ler.umInt();
			switch (diaesc) {
			case 1:
				dia = "Segunda-Feira";
				diacount = 2;
				break;

			case 2:
				dia = "Terça-Feira";
				diacount = 2;
				break;

			case 3:
				dia = "Quarta-Feira";
				diacount = 2;
				break;

			case 4:
				dia = "Quinta-Feira";
				diacount = 2;
				break;

			case 5:
				dia = "Sexta-Feira";
				diacount = 2;
				break;

			default:
				System.out.println("  Opção errada! Tente novamente!");
			}

		} while (diacount != 2);

		int horas;
		int minutos;

		System.out.println("  Insira as horas da aula: ");
		horas = Ler.umInt();
		System.out.println("  Insira os minutos da aula: ");
		minutos = Ler.umInt();

		int cont = 1;

		while (cont == 1) {
			for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
				if (((Curso.get(num).getAula().get(i).getHora() == horas
						&& Curso.get(num).getAula().get(i).getMinuto() == minutos
						&& Curso.get(num).getAula().get(i).getDia().equals(dia)))
						|| ((Curso.get(num).getAula().get(i).getHora() == horas
								&& Curso.get(num).getAula().get(i).getMinuto() == (minutos - 30)
								&& Curso.get(num).getAula().get(i).getDia().equals(dia)))
						|| ((Curso.get(num).getAula().get(i).getHora() == horas
								&& Curso.get(num).getAula().get(i).getMinuto() == (minutos + 30)
								&& Curso.get(num).getAula().get(i).getDia().equals(dia)))) {
					System.out.println("  Tem um aula marcada para as " + horas + ":" + minutos
							+ "! ( Tem de ter pelo menos 1 hora de diferença!");
					System.out.println("  Insira as horas da aula: ");
					horas = Ler.umInt();
					System.out.println("  Insira os minutos da aula: ");
					minutos = Ler.umInt();
					cont++;
				}
			}
			if (cont == 1) {
				cont = 0;
			} else {
				cont = 1;
			}
		}

		
		Aula a = new Aula(codigo, horas, minutos, nome, dia);

		Curso.get(num).addAula(a);

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

	
	 // ------------------- LISTAR AULAS ---------------------------------------- 
	  
	  
	public static void listarAula(ArrayList<Curso1> Curso, int num) {
		String listaraula = "";
		for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
			listaraula += Curso.get(num).getAula().get(i).toString() + "\n";
		}
		System.out.println("  [" + Curso.get(num).getAula().size() + "] aulas");
		System.out.println(listaraula);

	}

	
	 // ------------------- CONSULTAR AULA -------------------------------------- 
	 
	
	public static void consultarAula(ArrayList<Curso1> Curso, int num) {
		// dado nome, dado Professor, dado hora
		boolean verificar = true;
		int cont1 = 1;
		int escolha = 1;
		String totalaula;

		do {
			totalaula = "";
			System.out.println("*************************************");
			System.out.println(
					"Deseja consultar dado:\n  1 - Código de aula\n  2 - Professor\n  3 - Dia e/ou horas\n  4 - Voltar");
			System.out.print("*************************************\n  Opção: ");
			escolha = Ler.umInt();
			switch (escolha) {

			// dado o código
			case 1:
				int codigo = 1000;
				do {
					System.out.print("  Insira o código: ");
					codigo = Ler.umInt();
					for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
						if (codigo == Curso.get(num).getAula().get(i).getCodigo()) {
							totalaula += "\n" + Curso.get(num).getAula().get(i).toString();
						}
					}
				} while (codigo < 1000 && codigo > 9999);

				if (totalaula.equals("")) {
					System.out.println("  Não existem aulas com esse código!");
				} else {
					System.out.println(totalaula + "\n");
					escolha = 4;
				}
				break;

			// dado o Professor
			case 2:
				System.out.println("  Insira o nº do Professor: ");
				int numinst = Ler.umInt();
				for (int i = 0; i < Curso.get(num).getProf().size(); i++) {
					if (numinst == Curso.get(num).getProf().get(i).getNum_Prof()) {
						System.out
								.println("  Aulas do Professor:\n nº[" + Curso.get(num).getProf().get(i).getNum_Prof()
										+ "] " + Curso.get(num).getProf().get(i).getP_nome() + " "
										+ Curso.get(num).getProf().get(i).getU_nome());
						System.out.println(Curso.get(num).getProf().get(i).getProfaula());
					}
				}
				break;

			// dado o dia e/ou horas
			case 3:
				int escolhsemana = 1;
				String aulas = "";
				String[] dia = { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira",
						"Sábado", "Domingo" };
				while (cont1 == 1) {
					System.out.println(
							"  Qual o dia de semana que deseja ver?:\n  1 - Segunda-Feira\n  2 - Terça-Feira\n  3 - Quarta-Feira\n  4 - Quinta-Feira\n  5 - Sexta-Feira\n  6 - Sábado\n  7 - Domingo");
					escolhsemana = Ler.umInt();
					for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
						if (dia[escolhsemana - 1].equals(Curso.get(num).getAula().get(i).getDia())) {
							aulas += Curso.get(num).getAula().get(i).toString() + "\n";
						}
					}
					if (aulas.equals("")) {
						cont1 = 1;
						System.out.println("  Não tem aulas!");
					} else {
						cont1 = 0;
						System.out.println(aulas);
					}

				}

				break;

			// voltar
			case 4:
				System.out.println("A voltar...");
				break;

			default:
				System.out.println("  Opção errada! Tente novamente!");
			}
		} while (escolha != 4);
	}

	
	 //------------------- INSCREVER NUMA AULA --------------------------------- 
	
	
	public static void inscreverAula(ArrayList<Curso1> Curso, int num) {
		boolean verificar = true;

		// pedir o nº
		System.out.println("  Insira o número de Aluno: ");
		String totalnum = "";
		int numinscrito = -1;
		int numm = Ler.umInt();

		for (int j = 0; j < Curso.get(num).getAluno().size(); j++) {
			if (numm == Curso.get(num).getAluno().get(j).getNum_Aluno()) {
				totalnum = Curso.get(num).getAluno().get(j).toString();
				numinscrito = j;
			}
		}

		if (totalnum.equals("")) {
			System.out.println("  Não existe nenhum Aluno registado com esse número!");
		} else {
			System.out.println("  Deseja inscrever o seguinte Aluno?\n" + totalnum + "\n  1 - Sim\n  2 - Não");
			int escins = 1;
			do {
				escins = Ler.umInt();
				switch (escins) {
				case 1:
					String aulatot = "";

					do {
						System.out.println(
								"  Em qual das seguintes aulas pretende inscrever o Aluno? (Insira o código da aula)");
						String listaraula = "";
						for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
							listaraula += "\n" + Curso.get(num).getAula().get(i).toString() + "\n";
						}
						System.out.print(listaraula + "\n  Insira o código da aula: ");
						// codigo da aula
						int aula = Ler.umInt();
						for (int j = 0; j < Curso.get(num).getAula().size(); j++) {
							if (aula == Curso.get(num).getAula().get(j).getCodigo()) {
								aulatot = Curso.get(num).getAula().get(j).toString();
								for (int k = 0; k < Curso.get(num).getAluno().get(numinscrito).getAulas().size(); k++) {
									if (Curso.get(num).getAluno().get(numinscrito).getAulas().get(k)
											.getCodigo() == Curso.get(num).getAula().get(j).getCodigo()) {
										System.out.println(
												"  O Aluno que está a tentar inscrever na aula já está inscrito!");
										return;
									}
								}

								
								System.out.println("  Deseja inscrever na aula?\n"
										+ Curso.get(num).getAula().get(j).toString() + "\n1 - Sim\n2 - Não");
								int escoaula = Ler.umInt();
								switch (escoaula) {

								case 1:
									Curso.get(num).getAula().get(j)
											.addInscritos(Curso.get(num).getAluno().get(numinscrito));
									Curso.get(num).getAluno().get(numinscrito)
											.addAula(Curso.get(num).getAula().get(j));

									System.out.println("  Aluno ["
											+ Curso.get(num).getAluno().get(numinscrito).getNum_Aluno() + "] "
											+ Curso.get(num).getAluno().get(numinscrito).getP_nome() + " "
											+ Curso.get(num).getAluno().get(numinscrito).getU_nome()
											+ " está inscrito em " + Curso.get(num).getAula().get(j).getNome()
											+ ", estando marcada para " + Curso.get(num).getAula().get(j).getDia()
											+ " às " + Curso.get(num).getAula().get(j).getHora() + ":"
											+ Curso.get(num).getAula().get(j).getMinuto());
									escins = 2;
									verificar = false;
									break;

								case 2:
									System.out.println("  A voltar...");
									break;

								default:
									System.out.println("  Opção errada! Tente novamente!");
								}
							}
						}
					} while (verificar);

					break;

				case 2:
					System.out.println("  A sair...");
					escins = 2;
					break;

				default:
					System.out.println("  Opção errada! Tente novamente!");

				}
			} while (escins != 2);
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

	
	 // ------------------- ATRIBUIR PROFESSOR ---------------------------------- 
	
	
	public static void atribuirAula(ArrayList<Curso1> Curso, int num) {

		// pedir o nº do Professor
		String totalnum = "";
		boolean verificar = true;
		do {
			System.out.println("  Insira o número de Professor: ");
			totalnum = "";
			int numatribuido = -1;
			int numm = Ler.umInt();

			if (Curso.get(num).getProf().size() == 0) {
				System.out.println("Não existe Professor!");
				totalnum = " ";
			} else {
				for (int j = 0; j < Curso.get(num).getProf().size(); j++) {
					if (numm == Curso.get(num).getProf().get(j).getNum_Prof()) {
						totalnum = Curso.get(num).getProf().get(j).toString();
						numatribuido = j;
					}
				}

				if (totalnum.equals("")) {
					System.out.println("  Não existe nenhum Professor registado com esse número!");
				} else {
					do {
						System.out.println("  Introduza o código da aula que deseja atribuir o Professor");
						int codigo = Ler.umInt();

						for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
							if (codigo == Curso.get(num).getAula().get(i).getCodigo()) {
								if (Curso.get(num).getAula().get(i).getProfessor().size() < 2) {
									System.out.println("  Professor atribuído à aula "
											+ Curso.get(num).getAula().get(i).getNome());
									Curso.get(num).getAula().get(i)
											.addProfessor(Curso.get(num).getProf().get(numatribuido));
									Curso.get(num).getProf().get(numatribuido)
											.addAula(Curso.get(num).getAula().get(i));
									verificar = false;
								} else if (Curso.get(num).getAula().get(i).getProfessor().size() == 2) {
									System.out.println("  Já estão atribuídos 2 Professores a essa aula");
								}
							}
						}

					} while (verificar != false);
				}
			}
		} while (totalnum.equals(""));
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

	
	 // ------------------- ALTERAR AULA ---------------------------------------- 
	  
	  
	  
	public static void alterarAula(ArrayList<Curso1> Curso, int num) {
		boolean verificar = true;

		System.out.print("\nIntroduza o código da aula que deseja alterar: ");
		int codigo = Ler.umInt();

		for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
			if (codigo == Curso.get(num).getAula().get(i).getCodigo()) {
				int escolha = 1;
				do {
					System.out.println("*************************************");
					System.out.println("  Aula: " + Curso.get(num).getAula().get(i).toString());
					System.out.println(
							"  O que pretende alterar:\n  1 - Horas\n  2 - Código\n  3 - Nome\n  4 - Nº Máximo de Pessoas\n  4 - Dia de Semana\n  5 - Voltar");
					System.out.print("*************************************\n  Opção:");
					escolha = Ler.umInt();
					int escolha2 = 1;

					switch (escolha) {

					// horas
					case 1:
						do {
							System.out.println("  Deseja alterar:\n  1 - Horas\n  2 - Minutos\n  3 - Voltar");
							escolha2 = Ler.umInt();
							switch (escolha2) {

							// horas
							case 1:
								System.out.println("  Hora atual: " + Curso.get(num).getAula().get(i).getHora());
								int horas = Ler.umInt();
								int cont1 = 1;
								int minutos = Curso.get(num).getAula().get(i).getMinuto();
								String dia = Curso.get(num).getAula().get(i).getDia();
								while (cont1 == 1) {
									for (int j = 0; j < Curso.get(num).getAula().size(); j++) {
										if (Curso.get(num).getAula().get(j).getHora() == horas
												&& Curso.get(num).getAula().get(j).getMinuto() == minutos
												&& Curso.get(num).getAula().get(j).getDia().equals(dia)) {
											System.out.println(
													"  Já tem um aula marcada para as " + horas + ":" + minutos + "!");
											System.out.println("  Insira as horas da aula: ");
											horas = Ler.umInt();
											cont1++;
										}
									}
									if (cont1 == 1) {
										System.out.println("  Horário mudado para: " + dia + " às " + horas + "h"
												+ minutos + "min");
										Curso.get(num).getAula().get(i).setHora(horas);
										cont1 = 0;
									} else {
										cont1 = 1;
									}
								}

								break;

							// minutos
							case 2:
								System.out.println("  Minuto atual: " + Curso.get(num).getAula().get(i).getMinuto());
								int horas1 = Curso.get(num).getAula().get(i).getHora();
								int minutos1 = Ler.umInt();
								int cont2 = 1;
								String dia1 = Curso.get(num).getAula().get(i).getDia();
								while (cont2 == 1) {
									for (int j = 0; j < Curso.get(num).getAula().size(); j++) {
										if (Curso.get(num).getAula().get(j).getHora() == horas1
												&& Curso.get(num).getAula().get(j).getMinuto() == minutos1
												&& Curso.get(num).getAula().get(j).getDia().equals(dia1)) {
											System.out.println("  Já tem um aula marcada para as " + horas1 + ":"
													+ minutos1 + "!");
											System.out.println("  Insira os minutos da aula: ");
											minutos1 = Ler.umInt();
											cont2++;
										}
									}
									if (cont2 == 1) {
										System.out.println("  Horário mudado para: " + dia1 + " às " + horas1 + "h"
												+ minutos1 + "min");
										Curso.get(num).getAula().get(i).setMinuto(minutos1);
										cont2 = 0;
									} else {
										cont2 = 1;
									}
								}
								break;

							// voltar
							case 3:
								break;

							default:
								System.out.println("Opção errada! Tente novamente!");
							}

						} while (escolha2 != 3);
						break;

					// codigo
					case 2:
						System.out.println("  Código atual: " + Curso.get(num).getAula().get(i).getCodigo());
						int novocodigo = Ler.umInt();
						int cont3 = 1;
						while (cont3 == 1) {
							for (int j = 0; j < Curso.get(num).getAula().size(); j++) {
								if (Curso.get(num).getAula().get(j).getCodigo() == novocodigo) {
									System.out.println("  Já tem um aula com o código " + novocodigo + "!");
									System.out.println("  Insira o código: ");
									novocodigo = Ler.umInt();
									cont3++;
								}
							}
							if (cont3 == 1) {
								System.out.println("  Novo código: " + novocodigo);
								Curso.get(num).getAula().get(i).setCodigo(novocodigo);
								cont3 = 0;
							} else {
								cont3 = 1;
							}

						}
						break;

					// nome
					case 3:
						System.out.println("  Nome atual: " + Curso.get(num).getAula().get(i).getNome());
						String novonome = Ler.umaString();
						System.out.println("  Novo nome: " + novonome);
						Curso.get(num).getAula().get(i).setNome(novonome);

						break;

			
					// dia de semana
					case 4:
						int escolha3 = 0;
						int escolhadia;
						String[] novodia = { "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira",
								"Sexta-Feira", "Sábado", "Domingo" };
						do {
							System.out.println("  Dia de Semana atual: " + Curso.get(num).getAula().get(i).getDia());
							System.out.println(
									"  Novo dia de semana:\n  1 - Segunda-Feira\n  2 - Terça-Feira\n  3 - Quarta-Feira\n  4 - Quinta-Feira\n  5 - Sexta-Feira\n  6 - Sábado\n  7- Domingo");
							escolhadia = Ler.umInt();
							if (escolhadia < 1 || escolhadia > 7) {
								System.out.println("  Opção errada! Tente novamente!");
							} else {
								escolha3 = 1;
							}

						} while (escolha3 != 1);
						System.out.println("  Novo dia de semana: " + novodia[escolhadia - 1]);
						Curso.get(num).getAula().get(i).setDia(novodia[escolhadia - 1]);
						break;

					// voltar
					case 5:
						break;

					default:
						System.out.println("Opção errada!");
					}
				} while (escolha != 5);

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

	
	 // ------------------- APAGAR AULA ----------------------------------------- 
	
	
	
	public static void apagarAula(ArrayList<Curso1> Curso, int num) {
		System.out.println("*************************************");
		String listaraula = "";
		for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
			listaraula += "\n" + Curso.get(num).getAula().get(i).toString() + "\n";
		}

		System.out.println(listaraula);
		System.out.println("*************************************");
		System.out.print("  Introduza o código da aula que pretende apagar: ");
		int codigoaula = Ler.umInt();
		int cont1 = 1;
		while (cont1 == 1) {
			for (int j = 0; j < Curso.get(num).getAula().size(); j++) {
				if (Curso.get(num).getAula().get(j).getCodigo() == codigoaula) {
					int escolhapagar = 1;
					do {
						System.out.println("  Deseja apagar a seguinte aula:");
						System.out.println(Curso.get(num).getAula().get(j).toString());
						System.out.println("  1 - Sim\n  2 - Não");
						escolhapagar = Ler.umInt();
						switch (escolhapagar) {

						// sim
						case 1:
							System.out.println("  Aula apagada!");
							for (int i = 0; i < Curso.get(num).getAluno().size(); i++) {
								for (int k = 0; k < Curso.get(num).getAluno().get(i).getAulas().size(); k++) {
									if (Curso.get(num).getAluno().get(i).getAulas().get(k).getCodigo() == codigoaula) {
										Curso.get(num).getAluno().get(i).getAulas().remove(k);
									}
								}
							}
							for (int i = 0; i < Curso.get(num).getProf().size(); i++) {
								for (int k = 0; k < Curso.get(num).getProf().get(i).getProfaula().size(); k++) {
									if (Curso.get(num).getProf().get(i).getProfaula().get(k)
											.getCodigo() == codigoaula) {
										Curso.get(num).getProf().get(i).getProfaula().remove(k);
									}
								}
							}

							Curso.get(num).getAula().remove(j);
							escolhapagar = 2;
							cont1 = 0;

							break;

						// não
						case 2:
							System.out.println("  A voltar...");
							break;

						default:
							System.out.println("  Opção errada! Tente novamente!");

						}
					} while (escolhapagar != 2);
				}
			}
			if (cont1 == 1) {
				System.out.println("  Código introduzido não corresponde a nenhuma aula! Tente novamente!");
				System.out.print("  Introduza o código da aula que pretende apagar: ");
				codigoaula = Ler.umInt();
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

	
	 // ------------------- REMOVER ALUNO -------------------------------------- 
	
	
	 
	public static void removerAluno(ArrayList<Curso1> Curso, int num) {
		System.out.println("*************************************");
		System.out.println("  Lista de aulas:");
		String listaraula = "";
		for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
			listaraula += "\n\n" + Curso.get(num).getAula().get(i).toString() + "\n";
			for (int j = 0; j < Curso.get(num).getAula().get(i).getInscritos().size(); j++) {
				listaraula += "  nº [" + Curso.get(num).getAula().get(i).getInscritos().get(j).getNum_Aluno()
						+ "] Nome: " + Curso.get(num).getAula().get(i).getInscritos().get(j).getP_nome() + " "
						+ Curso.get(num).getAula().get(i).getInscritos().get(j).getU_nome() + "\n";
			}
		}
		System.out.println(listaraula);
		int cont1 = 1;
		do {
			System.out.println("*************************************");
			System.out.print("  De qual aula pretende remover o Aluno (Insira o código da aula: ");
			int codigoaula = Ler.umInt();
			String listaraula2 = "";
			for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
				if (codigoaula == Curso.get(num).getAula().get(i).getCodigo()) {
					System.out.println("  Aula: " + Curso.get(num).getAula().get(i).toString());
					for (int j = 0; j < Curso.get(num).getAula().get(i).getInscritos().size(); j++) {
						listaraula2 += "  nº [" + Curso.get(num).getAula().get(i).getInscritos().get(j).getNum_Aluno()
								+ "] Nome: " + Curso.get(num).getAula().get(i).getInscritos().get(j).getP_nome() + " "
								+ Curso.get(num).getAula().get(i).getInscritos().get(j).getU_nome() + "\n";
					}
					do {
						System.out.println(listaraula2);
						System.out.println("  Qual dos Alunos deseja alterar? Introduza o número de Aluno");
						int Aluno = Ler.umInt();

						for (int k = 0; k < Curso.get(num).getAula().get(i).getInscritos().size(); k++) {
							if (Curso.get(num).getAula().get(i).getInscritos().get(k).getNum_Aluno() == Aluno) {

								cont1++;
							}
						}
						if (cont1 == 1) {
							System.out.println("  Aluno errado!");
							cont1 = 1;
						} else {
							for (int l = 0; l < Curso.get(num).getAluno().size(); l++) {
								if (Curso.get(num).getAluno().get(l).getNum_Aluno() == Aluno) {
									Curso.get(num).getAluno().get(l)
											.removeAula(Curso.get(num).getAula().get(i).getCodigo());
								}
							}
							Curso.get(num).getAula().get(i).removeInscritos(Aluno);
							System.out.println("  Aluno removido");
							cont1 = 0;
						}
					} while (cont1 == 1);
				}
			}
		} while (cont1 == 1);
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

	
	 // ------------------- REMOVER PROFESSOR ----------------------------------- 
	 
	
	public static void removerProfessor(ArrayList<Curso1> Curso, int num) {
		System.out.println("*************************************");
		System.out.println("  Lista de aulas:");
		String listaraula = "";
		for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
			listaraula += "\n\n" + Curso.get(num).getAula().get(i).toString() + "\n";
			for (int j = 0; j < Curso.get(num).getAula().get(i).getProfessor().size(); j++) {
				listaraula += "  nº [" + Curso.get(num).getAula().get(i).getProfessor().get(j).getNum_Prof()
						+ "] Nome: " + Curso.get(num).getAula().get(i).getProfessor().get(j).getP_nome() + " "
						+ Curso.get(num).getAula().get(i).getProfessor().get(j).getU_nome() + "\n";
			}
		}
		System.out.println(listaraula);
		int cont1 = 1;
		do {
			System.out.println("*************************************");
			System.out.print("  De qual aula pretende remover o Professor (Insira o código da aula: ");
			int codigoaula = Ler.umInt();
			String listaraula2 = "";
			for (int i = 0; i < Curso.get(num).getAula().size(); i++) {
				if (codigoaula == Curso.get(num).getAula().get(i).getCodigo()) {
					System.out.println("  Aula: " + Curso.get(num).getAula().get(i).toString());
					for (int j = 0; j < Curso.get(num).getAula().get(i).getProfessor().size(); j++) {
						listaraula2 += "  nº [" + Curso.get(num).getAula().get(i).getProfessor().get(j).getNum_Prof()
								+ "] Nome: " + Curso.get(num).getAula().get(i).getProfessor().get(j).getP_nome() + " "
								+ Curso.get(num).getAula().get(i).getProfessor().get(j).getU_nome() + "\n";
					}
					do {
						System.out.println(listaraula2);
						System.out.println("  Qual dos Professores deseja alterar? Introduza o número de Professor");
						int Aluno = Ler.umInt();
						int kk = 0;

						for (int k = 0; k < Curso.get(num).getAula().get(i).getProfessor().size(); k++) {
							if (Curso.get(num).getAula().get(i).getProfessor().get(k).getNum_Prof() == Aluno) {
								kk = k;
								cont1++;
							}
						}
						if (cont1 == 1) {
							System.out.println("  Professor errado!");
							System.out.println(Curso.get(num).getAula().get(i).getProfessor().get(kk).getNum_Prof());
							cont1 = 1;
						} else {
							for (int l = 0; l < Curso.get(num).getProf().size(); l++) {
								if (Curso.get(num).getProf().get(l).getNum_Prof() == Aluno) {
									Curso.get(num).getProf().get(l)
											.removeAula(Curso.get(num).getAula().get(i).getCodigo());
								}
							}
							Curso.get(num).getAula().get(i).removeProfessor(Aluno);
							System.out.println("  Professor removido");
							cont1 = 0;
						}
					} while (cont1 == 1);
				}
			}
		} while (cont1 == 1);
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