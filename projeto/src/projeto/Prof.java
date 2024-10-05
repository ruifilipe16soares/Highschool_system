package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Prof extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	private String cadeira;
	private int num_Prof;
	private ArrayList<Aula> profaula;
	
	public Prof(Pessoa p, String cadeira) {
		super(p.getP_nome(), p.getU_nome(), p.getNif(), p.getDataNasc().getDayOfMonth(), p.getDataNasc().getMonthValue(), p.getDataNasc().getYear(), p.getSexo());
		this.cadeira = cadeira;
		num_Prof = 0;
		profaula = new ArrayList<Aula>();
	}

	public String getCadeira() {
		return cadeira;
	}

	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}
	
	public int getNum_Prof() {
		return num_Prof;
	}

	public void setNum_Prof(int num_Prof) {
		this.num_Prof = num_Prof;
	}

	@Override
	public String toString() {
		return "  Nº [" + num_Prof + "]\n" +  super.toString() + "\n  Disciplina: " + cadeira + "\n";
	}

	public ArrayList<Aula> getProfaula() {
		return profaula;
	}

	public void setProfaula(ArrayList<Aula> profaula) {
		this.profaula = (ArrayList<Aula>) profaula.clone();
	}
	
	public void addAula(Aula a) {
		profaula.add(a);
	}
	
	public void removeAula(int num) {
		for(int i = 0; i < profaula.size(); i++) {
			if(profaula.get(i).getCodigo() == num) {
				profaula.remove(i);
			}
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prof other = (Prof) obj;
		return Objects.equals(profaula, other.profaula) && num_Prof == other.num_Prof
				&& Objects.equals(cadeira, other.cadeira);
	}

	
}