public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        for(int i=0; i<this.letrasJaDigitadas.length();i++){
            if(this.letrasJaDigitadas.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
        if(this.isJaDigitada(letra)){
            throw new Exception("A letra \'" + letra + "\' já foi digitada");
        }

        this.letrasJaDigitadas+=letra;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            resultado += this.letrasJaDigitadas.charAt(i);
            if (i < this.letrasJaDigitadas.length() - 1) {
                resultado += ", ";
            }
        }
        return resultado;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass() != obj.getClass()) return false;

        ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas) obj;
        if(this.letrasJaDigitadas != c.letrasJaDigitadas) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + String.valueOf(this.letrasJaDigitadas).hashCode();

        if(ret<0) ret = -ret;

        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception
    {
        if(controladorDeLetrasJaDigitadas==null) throw new Exception("Modelo ausente");

        this.letrasJaDigitadas=controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    @Override
    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas ret=null;

        try{
            ret = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception erro){}

        return ret;
    }
}
