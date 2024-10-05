package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Aula implements Serializable{
	private static final long serialVersionUID = 1L;
	private int hora;
	private int minuto;
	private String nome;
	private ArrayList<Aluno> inscritos;
	private ArrayList<Prof> professor;
	private String dia;
	private int codigo;
	
	public Aula(int codigo, int hora, int minuto, String nome, String dia) {
		this.hora = hora;
		this.minuto = minuto;
		this.nome = nome;
		this.dia = dia;
		inscritos = new ArrayList<Aluno>();
		professor = new ArrayList<Prof>();
		this.codigo = codigo;
		
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public ArrayList<Aluno> getInscritos() {
		return inscritos;
	}

	public void setInscritos(ArrayList<Aluno> inscritos) {
		this.inscritos = inscritos;
	}
	
	public void addInscritos(Aluno mem) {
		inscritos.add(mem);
	}
	
	public void removeInscritos(int num) {
		for(int i = 0; i < inscritos.size(); i++) {
			if(inscritos.get(i).getNum_Aluno() == num) {
				inscritos.remove(i);
			}
		}
	
		
	}

	@Override
	public String toString() {
		String instruct = "";
		try {
			for(int i = 0; i < professor.size(); i++) {
				instruct += "\n  [" + professor.get(i).getNum_Prof() + "] " + professor.get(i).getP_nome() + " " + professor.get(i).getU_nome();
			}
		}
		catch(NullPointerException n) {
			instruct = " SEM professor";
		}
		
		return "\n  CÓDIGO [" + codigo + "] - Aula de " + nome + "\n  Horário: " + dia + " às " + hora + "h" + minuto + "min\n  Professor:" + instruct;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Prof> getProfessor() {
		return professor;
	}

	public void setProfessor(ArrayList<Prof> professor) {
		this.professor = (ArrayList<Prof>) professor.clone();
	}
	
	public void addProfessor(Prof instruct) {
		professor.add(instruct);
	}
	
	public void removeProfessor(int num) {
		for(int i = 0; i < professor.size(); i++) {
			if(professor.get(i).getNum_Prof() == num) {
				professor.remove(i);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return codigo == other.codigo && Objects.equals(dia, other.dia) && hora == other.hora
				&& Objects.equals(inscritos, other.inscritos) && Objects.equals(professor, other.professor)
				&& minuto == other.minuto && Objects.equals(nome, other.nome);
	}
	
}