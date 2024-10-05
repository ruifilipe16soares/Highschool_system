package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Curso1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int ultimo = 0; // static do valor do nº do curso
	private int num;
	private String nome;
	private ArrayList<String> turmas;
	private ArrayList<Aula> aulas;
	private ArrayList<Aluno> alunos;
	private ArrayList<Pessoa> pessoas;
	private ArrayList<Prof> professores;

	public Curso1(String nome) {
		ultimo++;
		this.nome = nome;
		turmas = new ArrayList<String>();
		aulas = new ArrayList<Aula>();
		alunos = new ArrayList<Aluno>();
		pessoas = new ArrayList<Pessoa>();
		professores = new ArrayList<Prof>();
		num = ultimo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getTurma() {
		return turmas;
	}

	public void setTurma(ArrayList<String> turmas) {
		this.turmas = turmas;
	}

	public ArrayList<Aula> getAula() {
		return aulas;
	}

	public void setAula(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	public ArrayList<Aluno> getAluno() {
		return alunos;
	}

	public void setAluno(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public ArrayList<Pessoa> getPessoa() {
		return pessoas;
	}

	public void setPessoa(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public ArrayList<Prof> getProf() {
		return professores;
	}

	public void setProf(ArrayList<Prof> professores) {
		this.professores = professores;
	}

	public void addProf(Prof Profs) {
		professores.add(Profs);
	}

	public static int getUltimo() {
		return ultimo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		//String alunostring = "";
		String professorestring = "";
		String aulastring = "";
		//String turmastring = "";

		/*for (int i = 0; i < alunos.size(); i++) {
			alunostring += "*---------------------------------*\n" + alunos.get(i).toString();
		}*/

		for (int j = 0; j < professores.size(); j++) {
			professorestring += "*---------------------------------*\n" + professores.get(j).toString();
		}

		for (int k = 0; k < aulas.size(); k++) {
			aulastring += "\n" + aulas.get(k).toString() + "\n";
		}

		/*
		for (int l = 0; l < turmas.size(); l++) {
			turmastring += "\n  - " + (turmas.get(l).toString()) + "\n";
		} */
		
		String nomenum = num + nome;
		String nomenum2 = "*";
		for (int m = 0; m < nomenum.length() + 15; m++) {
			nomenum2 += "-";
		}

		return "\n" + nomenum2 + "*\n| Nº[" + num + "] - NOME: " + nome + " |\n" + nomenum2
				+ "*\n\n\n *--------*\n | Turmas |\n *--------*\n" + "3 turmas, 1 por cada ano." + "\n"
				+ "\n\n *-------*\n | Aulas |\n *-------*\n" + aulastring
				+ "\n\n *-------*\n | Prof |\n *-------*\n"
				+ professorestring + "\n****************************************\n" + "\n  Total de Alunos+Profs [" + (alunos.size() + professores.size())
				+ "]\n****************************************\n";
	}

	public static void setUltimo(int ult) {
		ultimo = ult;
	}

	public void addPax(Prof mem) {
		pessoas.add(mem);
	}

	public void addAula(Aula a) {
		aulas.add(a);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso1 other = (Curso1) obj;
		return Objects.equals(aulas, other.aulas) && Objects.equals(alunos, other.alunos)
				&& Objects.equals(nome, other.nome) && num == other.num && Objects.equals(turmas, other.turmas)
				&& Objects.equals(professores, other.professores)
				&& Objects.equals(pessoas, other.pessoas);
	}

}