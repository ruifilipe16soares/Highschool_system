package projeto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.DateTimeException;
import java.util.ArrayList;

import myinputs.Ler;

public class FuncProf {
	// ------------------- CRIAR Prof -----------------------------------------
	 
	public static void criarProf(ArrayList<Curso1> Curso, int num) {
		boolean verif = true;
		
		System.out.println("  Insira o primeiro nome: ");
		String p_nome = Ler.umaString();
		
		System.out.println("  Insira o último nome: ");
		String u_nome = Ler.umaString();
		
		System.out.println("  Insira o NIF: ");
		int nif = Ler.umInt();
		for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
			if(Curso.get(num).getProf().get(i).getNif() == nif) {
				System.out.println("  O NIF [" + nif + "] já está registado no sistema!");
				return;
			}
		}
		char sexo = 'A';
		while(sexo != 'M' && sexo != 'm' && sexo != 'F' && sexo != 'f') { 
			System.out.println("  Insira o seu género (M ou F)");
			sexo = Ler.umChar();
		}
		
		
		int dia = 1, mes = 1, ano = 1;

		System.out.println("  Insira a Cadeira: ");
		String Cadeira = Ler.umaString();
		
		Pessoa pax = new Pessoa(p_nome, u_nome, nif, dia, mes, ano, sexo);
		
		System.out.println("Insira a sua data de nascimento ");
		verif = true;
		while(verif) {
			try {
				System.out.println("Ano: ");
				ano = Ler.umInt();
				System.out.println("Mês (1-12): ");
				mes = Ler.umInt();
				System.out.println("Dia: ");
				dia = Ler.umInt();
				pax.setDataNasc(ano, mes, dia);
				verif = false;
			}
			catch(DateTimeException d) {
				System.out.println("Valores errados! Tente novamente! (Lembre-se: Meses de 1 a 12!)");
			}
		}
		
		Prof mem = new Prof(pax, Cadeira);
		
		mem.setNum_Prof(Curso.get(num).getProf().size() + 1);
		
		for(int j = 0; j < Curso.get(num).getProf().size(); j++) {
			if(mem.getNum_Prof() == Curso.get(num).getProf().get(j).getNum_Prof()) {
				mem.setNum_Prof(mem.getNum_Prof() + 1);
			}
		}
		
		Curso.get(num).addProf(mem);
		Curso.get(num).addPax(mem);
		
		try {
		      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("escola.md"));

		      // escrever o objeto no ficheiro
		      os.writeInt(Curso1.getUltimo());
		      os.writeObject(Curso);
		      os.flush();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ------------------- CONSULTAR Prof ------------------------------------- 
	 
	public static void consultarProf(ArrayList<Curso1> Curso, int num) {
		int escolha = 1;
		do {
			System.out.println("*************************************");
			System.out.println("Deseja consultar dado:\n  1 - Nome\n  2 - Número de Prof\n  3 - NIF\n  4 - Voltar");
			System.out.print("*************************************\n  Opção:");
			escolha = Ler.umInt();
			switch(escolha) {
			
			// dado o nome
			case 1: System.out.println("  Insira o primeiro nome: ");
					String totalnome = "";
					String p_nome = Ler.umaString();
					for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
						if(Curso.get(num).getProf().get(i).getP_nome().equals(p_nome)) {
							System.out.println("  Insira o último nome: ");
							String u_nome = Ler.umaString();
							if(Curso.get(num).getProf().get(i).getU_nome().equals(u_nome)) {
								totalnome += Curso.get(num).getProf().get(i).toString() + "\n";
							}
						}
					}
					
					if(totalnome.equals("")) {
						System.out.println("  Não existe nenhum Prof registado com esse nome!");
					}
					else {
						System.out.println(totalnome);
						escolha = 4;
					}
			break;
			
			// dado o número de membro
			case 2: System.out.println("  Insira o número de Prof: ");
					String totalnum = "";
					int numm = Ler.umInt();
					
					for(int j = 0; j < Curso.get(num).getProf().size(); j++) {
						if(numm == Curso.get(num).getProf().get(j).getNum_Prof()) {
							totalnum = Curso.get(num).getProf().get(j).toString();
						}
					}
					
					if(totalnum.equals("")) {
						System.out.println("  Não existe nenhum Prof registado com esse número!");
					}
					else {
						System.out.println(totalnum);
						escolha = 4;
					}
			break;
			
			// dado o nif
			case 3: System.out.println("  Insira o NIF: ");
					String totalnif = "";
					int nif = Ler.umInt();
					
					for(int k = 0; k < Curso.get(num).getProf().size(); k++) {
						if(nif == Curso.get(num).getProf().get(k).getNif()) {
							totalnif = Curso.get(num).getProf().get(k).toString();
						}
					}
					
					if(totalnif.equals("")) {
						System.out.println("  Não existe nenhum Prof registado com esse NIF!");
					}
					else {
						System.out.println(totalnif);
						escolha = 4;
					}
			break;
			}
		} while(escolha != 4);
	}
	
	// ------------------- APAGAR Prof ---------------------------------------- 
	 
	public static void apagarProf(ArrayList<Curso1> Curso, int num) {
		int controlo = 1;
		while(controlo != 3) {
			System.out.println("  Insira o número do Prof que pretende alterar: ");
			int numem = Ler.umInt();
			
			for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
				if(numem == Curso.get(num).getProf().get(i).getNum_Prof()) {
					int controlo2 = 1;
					do {
						System.out.println("  Deseja remover o seguinte Prof? \n" + Curso.get(num).getProf().get(i).toString() + "\n 1 - Sim\n 2- Não");
						controlo2 = Ler.umInt();
						if(controlo2 == 1) { // se 1 - Sim, remove o membro e sai
							Curso.get(num).getProf().remove(i);
							System.out.println("  Prof removido com sucesso!");
							for(int j = 0; j < Curso.get(num).getAula().size(); j++) {
								if(Curso.get(num).getAula().get(j).getProfessor().get(0).getNum_Prof() == numem){
									Curso.get(num).getAula().get(j).getProfessor().remove(0);
								}
								else if(Curso.get(num).getAula().get(j).getProfessor().get(1).getNum_Prof() == numem) {
									Curso.get(num).getAula().get(j).getProfessor().remove(1);
								}
							}
							
							return;	
						}
						else if(controlo2 == 2) { // se 2 - Não, repete!
							controlo2 = 2;
						}
					} while(controlo2 != 2);
				}
			}
			System.out.println("  Não existe nenhum Prof com esse número");
		}
		
		
		
		try {
		      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("escola.md"));

		      // escrever o objeto no ficheiro
		      os.writeInt(Curso1.getUltimo());
		      os.writeObject(Curso);
		      os.flush();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ------------------- ALTERAR Prof --------------------------------------- 
	 
	public static void alterarProf(ArrayList<Curso1> Curso, int num) {
		boolean verif = true;
		
		System.out.println("  Insira o número do Prof que pretende alterar");
		int numm = Ler.umInt();
		
		for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
			if(Curso.get(num).getProf().get(i).getNum_Prof() == numm) {
				int escolha = 1;
				do {
					System.out.println("*************************************");
					System.out.println(Curso.get(num).getProf().get(i).toString()+ "\n");
					System.out.println("O que pretende alterar:\n  1 - Nome\n  2 - NIF\n  3 - Data de Nascimento\n  4 - Sexo\n  5 - Cadeira\n  6 - Voltar");
					System.out.print("*************************************\n  Opção:");
					escolha = Ler.umInt();
					switch(escolha) {
					
					// --------------- mudar o nome ------------------
					case 1: int escnome = 1;
							do {
								System.out.println("*************************************");
								System.out.println("Deseja alterar:\n  1 - Primeiro Nome\n  2 - Último Nome\n  3 - Ambos\n  4 - Voltar");
								System.out.print("*************************************\n  Opção: ");
								escnome = Ler.umInt();
								switch(escnome) {
								case 1:	System.out.println("  Insira o novo Primeiro nome: ");
										String p_nome = Ler.umaString();
										
										Curso.get(num).getProf().get(i).setP_nome(p_nome); // set Primeiro nome
								break;
								
								case 2: System.out.println("  Insira o novo Último nome: ");
										String u_nome = Ler.umaString();
										
										Curso.get(num).getProf().get(i).setU_nome(u_nome); // set Último nome
								break;
								
								case 3: System.out.println("  Insira o novo Primeiro nome: ");
										String p_nome2 = Ler.umaString();
										System.out.println("  Insira o novo Último nome: ");
										String u_nome2 = Ler.umaString();
										
										Curso.get(num).getProf().get(i).setP_nome(p_nome2); // set Primeiro nome
										Curso.get(num).getProf().get(i).setU_nome(u_nome2); // set Último nome
								}
								
							} while(escnome != 4);
					break;
					
					// --------------- mudar o nif ------------------
					case 2:	int escnif = 1;
							while(escnif == 1) {
								System.out.println("  Insira o novo NIF: ");
								int nif = Ler.umInt();
							
								for(int l = 0; l < Curso.get(num).getProf().size(); l++) {
									if(nif == Curso.get(num).getProf().get(l).getNif()) {
										System.out.println("  Já existe um NIF igual registado!");
										escnif = 0;
									}
								}
								Curso.get(num).getProf().get(i).setNif(nif); // set do novo nif
								escnif = 0;	
							}	
					break;
					
					// --------------- mudar a idade ------------------
					case 3:	int escidade = 1;
							do {
								System.out.println("*************************************");
								System.out.println("Deseja alterar:\n  1 - Dia\n  2 - Mês\n  3 - Ano\n  4 - Voltar");
								System.out.print("*************************************\n  Opção: ");
								escidade = Ler.umInt();
								switch(escidade) {
								case 1:	verif = true;
										while(verif) {
											try {
												System.out.println("  Insira o novo dia: ");
												int dia = Ler.umInt();
												Curso.get(num).getProf().get(i).setDataNasc(Curso.get(num).getAluno().get(i).getDataNasc().getYear(), Curso.get(num).getAluno().get(i).getDataNasc().getMonthValue(), dia);
												verif = false;
											}
											catch(DateTimeException d) {
												System.out.println("Valor errado! Tente novamente!");
											}
										}
								break;
						
								case 2: verif = true;
										while(verif) {
										try {
											System.out.println("  Insira o novo mês (1-12): ");
											int mes = Ler.umInt();
											Curso.get(num).getProf().get(i).setDataNasc(Curso.get(num).getAluno().get(i).getDataNasc().getYear(), mes, Curso.get(num).getAluno().get(i).getDataNasc().getDayOfMonth());
											verif = false;
										}
										catch(DateTimeException d) {
											System.out.println("Valor errado! Insira um valor entre 1 e 12");
										}
									}
										
								break;
						
								case 3:	verif = true;
										while(verif) {
										try {
											System.out.println("  Insira o novo ano: ");
											int ano = Ler.umInt();
											Curso.get(num).getProf().get(i).setDataNasc(ano, Curso.get(num).getAluno().get(i).getDataNasc().getMonthValue(), Curso.get(num).getAluno().get(i).getDataNasc().getDayOfMonth());
											verif = false;
										}
										catch(DateTimeException d) {
											System.out.println("Valor errado! Tente novamente!");
										}
									}
										
								break;
								
								case 4:
								break;
								
								default: System.out.println("  Opção inválida! Tente novamente");
								}
							} while(escidade!= 4);
					break;
					
					// --------------- mudar o sexo --------------------
					case 4:	int escsexo = 1;
							char novosexo = 'F';
							while(escsexo == 1) {
								System.out.println("  Sexo atual: " + Curso.get(num).getProf().get(i).getSexo());
								System.out.println("  Insira o novo sexo (M ou F):");
								novosexo = Ler.umChar();
								
								if(novosexo != 'M' && novosexo != 'm' && novosexo != 'F' && novosexo != 'f') {
									System.out.println("  Caracter introduzido não permitido, apenas permitido M ou F!");
								}
								else {
									escsexo = 2;
								}
							}
							Curso.get(num).getProf().get(i).setSexo(novosexo);
					break;
					
					// --------------- mudar a Cadeira --------------------
					case 5:	String novoCadeira = "nova";
							System.out.println("  Disciplina atual: " + Curso.get(num).getProf().get(i).getCadeira());
							System.out.println("  Insira a nova disciplina: ");
							novoCadeira = Ler.umaString();
							Curso.get(num).getProf().get(i).setCadeira(novoCadeira);
					break;
					
					// --------------- sair ----------------------------
					case 6:
					break;
					
					default: System.out.println("  Opção inválida! Tente novamente");
					}
					
				} while(escolha != 6);
			}
		}
		
		
		try {
		      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("escola.md"));

		      // escrever o objeto no ficheiro
		      os.writeInt(Curso1.getUltimo());
		      os.writeObject(Curso);
		      os.flush();
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ------------------- LISTAR Prof ---------------------------------------- 
	 
	public static void listarProf(ArrayList<Curso1> Curso, int num) {
		String listProf = "";
		for(int i = 0; i < Curso.get(num).getProf().size(); i++) {
			listProf += Curso.get(num).getProf().get(i).toString() + "\n******************************\n";
		}
		
		System.out.println(listProf);
	}
	
}