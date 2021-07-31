import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {


    public List<Contato> getContatos() {
        return null;
    }

    public int getQuantidadeDeContatos() { return 0; }

    public Contato getContato(String name){
        return null;
    }

    public boolean adicionarContato(Contato contato){
        return true;
    }

    public boolean removerContato(String name){
        return false;
    }

    public boolean removerFone(String name, int index){
        return false;
    }

    public int getQuantidadeDeFones(Identificador identificador){
        return 0;
    }

    public int getQuantidadeDeFones(){
        return 0;
    }

    public ArrayList<Contato> pesquisar(String expressao){
        return null;
    }

}