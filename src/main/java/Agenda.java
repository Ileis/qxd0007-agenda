import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {

    private HashMap<String, Contato> agendaDeContatos;
    private List<Contato> listaContatos;

    public Agenda(){
        agendaDeContatos = new HashMap<String, Contato>();
        listaContatos = new LinkedList<Contato>();
    }

    public List<Contato> getContatos() {
        Collections.sort(listaContatos);

        return listaContatos;
    }

    private List<Contato> getListaContatos(){
        return listaContatos;
    }

    public int getQuantidadeDeContatos() {
        return agendaDeContatos.size();
    }

    public Contato getContato(String name){
        return agendaDeContatos.get(name);
    }

    public boolean adicionarContato(Contato contato){

        if(contato.getQuantidadeFones() > 0){
            if(agendaDeContatos.containsKey(contato.getName())) {

                int indexContatoAntigo = listaContatos.indexOf(agendaDeContatos.get(contato.getName()));

                for(Fone fone : contato.getFones()) {
                    if(!agendaDeContatos.get(contato.getName()).getFones().contains(fone))
                        agendaDeContatos.get(contato.getName()).getFones().add(fone);
                }

                listaContatos.set(indexContatoAntigo, agendaDeContatos.get(contato.getName()));

                return false;
            }else{
                listaContatos.add(contato);
                agendaDeContatos.put(contato.getName(), contato);

                return true;
            }
        }
        return false;
    }

    public boolean removerContato(String name){
        if(agendaDeContatos.containsKey(name)){
            listaContatos.remove(agendaDeContatos.get(name));
            agendaDeContatos.remove(name);

            return true;
        }
        return false;
    }

    public boolean removerFone(String name, int index){
        if(agendaDeContatos.containsKey(name))
            return agendaDeContatos.get(name).removerFone(index);
        return false;
    }

    public int getQuantidadeDeFones(Identificador identificador){
        int contador = 0;

        for(Contato contato : getListaContatos()){
            contador += contato.getQtdContatosTipo(identificador);
        }

        return contador;
    }

    public int getQuantidadeDeFones(){
        int contador = 0;

        for(Contato contato : getListaContatos()){
            contador += contato.getQuantidadeFones();
        }

        return contador;
    }

    public ArrayList<Contato> pesquisar(String expressao){
        ArrayList<Contato> contatos;

        if(Fone.validarNumero(expressao))
            contatos = pesquisarNumero(expressao);
        else
            contatos = pesquisarLetra(expressao);


        return contatos;
    }

    private ArrayList<Contato> pesquisarLetra(String expressao){

        ArrayList<Contato> contatos = new ArrayList<Contato>();

        if(expressao.equals(Identificador.CASA.toString())) {
            for(Contato contato : getContatos()){
                if(contato.getQtdContatosTipo(Identificador.CASA) > 0)
                    contatos.add(contato);
            }
        }

        else if(expressao.equals(Identificador.TRABALHO.toString())) {
            for(Contato contato : getContatos()){
                if(contato.getQtdContatosTipo(Identificador.TRABALHO) > 0)
                    contatos.add(contato);
            }
        }

        else if(expressao.equals(Identificador.CELULAR.toString())) {
            for(Contato contato : getContatos()){
                if(contato.getQtdContatosTipo(Identificador.CELULAR) > 0)
                    contatos.add(contato);
            }
        }

        else {
            for(Contato contato : getContatos()){
                if(contato.getName().contains(expressao))
                    contatos.add(contato);
            }
        }

        return contatos;
    }

    private ArrayList<Contato> pesquisarNumero(String numero){

        ArrayList<Contato> contatos = new ArrayList<Contato>();

        for(Contato contato : getContatos()){
            for(int index = 0; index < contato.getQuantidadeFones(); index++){
                if(contato.getFones().get(index).getNumero().contains(numero))
                    contatos.add(contato);
            }
        }

        return contatos;
    }
}