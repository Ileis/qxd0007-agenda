import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Contato implements Comparable<Contato> {

    private String nomeContato;
    private ArrayList<Fone> fones;
    private int qtdIdentificadorCasa = 0;
    private int qtdIdentificadorTrabalho = 0;
    private int qtdIdentificadorCelular = 0;

    public Contato(String name){
        this.nomeContato = name;
        fones = new ArrayList<Fone>();
    }

    @Override
    public int compareTo(Contato contato) {
        return nomeContato.compareTo(contato.getName());
    }

    public String getName() {
        return nomeContato;
    }

    public int getQuantidadeFones(){
        return fones.size();
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }

    public boolean adicionarFone(Fone fone){
        if(Fone.validarNumero(fone.getNumero())){
            adicionaContadorIdentificador(fone.getIdentificador());
            fones.add(fone);

            return true;
        }
        return false;
    }

    private void adicionaContadorIdentificador(Identificador identificador){
        if(identificador == Identificador.CASA)
            qtdIdentificadorCasa++;
        else if(identificador == Identificador.CELULAR)
            qtdIdentificadorCelular++;
        else if(identificador == Identificador.TRABALHO)
            qtdIdentificadorTrabalho++;
    }

    private void removeContadorIdentificador(Identificador identificador){
        if(identificador == Identificador.CASA)
            qtdIdentificadorCasa--;
        else if(identificador == Identificador.CELULAR)
            qtdIdentificadorCelular--;
        else if(identificador == Identificador.TRABALHO)
            qtdIdentificadorTrabalho--;
    }

    public boolean removerFone(int index){
        if(index < fones.size() && index >= 0){
            removeContadorIdentificador(fones.get(index).getIdentificador());
            fones.remove(index);

            return true;
        }
        return false;
    }

    public int getQtdContatosTipo(Identificador identificador){

        if(identificador == Identificador.CASA)
            return qtdIdentificadorCasa;
        else if(identificador == Identificador.TRABALHO)
            return qtdIdentificadorTrabalho;
        else if(identificador == Identificador.CELULAR)
            return qtdIdentificadorCelular;

        return 0;
    }
}