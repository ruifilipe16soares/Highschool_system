package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private int num_aluno;
    private ArrayList<Aula> aulas;
    private String turma;
    private String horario;

    public Aluno(Pessoa p) {
        super(p.getP_nome(), p.getU_nome(), p.getNif(), p.getDataNasc().getDayOfMonth(), p.getDataNasc().getMonthValue(), p.getDataNasc().getYear(), p.getSexo());
        turma = " ";
        num_aluno = 0;
        aulas = new ArrayList<Aula>();
        horario = " "; 
    }

    public int getNum_Aluno() {
        return num_aluno;
    }

    public void setNum_Aluno(int num_aluno) {
        this.num_aluno = num_aluno;
    }

    public ArrayList<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(ArrayList<Aula> aulas) {
        this.aulas = (ArrayList<Aula>) aulas.clone();
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void addAula(Aula a) {
        aulas.add(a);
    }

    public void removeAula(int num) {
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getCodigo() == num) {
                aulas.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "  Nº[" + num_aluno + "]\n" + super.toString() + "\n  Aulas: " + aulas + "\n  Turma: " + turma + "\n  Horário: " + horario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        return Objects.equals(aulas, other.aulas) && num_aluno == other.num_aluno && turma == other.turma && horario.equals(other.horario);
    }
}
