public class Fone {

    private Identificador identificador;
    private String numero;
    private static final String VALID_CHAR = "0123456789()-";

    public Fone(Identificador identificador, String numero){
        this.identificador = identificador;
        this.numero = numero;
    }

    public static boolean validarNumero(String numero){
        for(int indexNum = 0; indexNum < numero.length(); indexNum++){
            boolean valido = false;
            for(int indexValidChar = 0; indexValidChar < VALID_CHAR.length(); indexValidChar++){
                if(numero.charAt(indexNum) == VALID_CHAR.charAt(indexValidChar))
                    valido = true;
            }
            if(!valido)
                return false;
        }
        return true;
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public String getNumero() {
        return numero;
    }
}
