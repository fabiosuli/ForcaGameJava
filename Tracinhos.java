import java.util.Arrays;

public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if(qtd <= 0) {
            throw new Exception("A quantidade de tracinhos deve ser maior que 0");
        }
        this.texto = new char[qtd];

        for(int i=0; i<qtd; i++){
            this.texto[i] = '_';
        }
    }

    public void revele(int posicao, char letra) throws Exception {
        if (posicao < 0 || posicao >= this.texto.length) {
            throw new Exception("Posição inválida");
        }
        this.texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        for(int i=0; i<this.texto.length; i++){
            if(this.texto[i] == '_'){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString ()
    {
        String resultado = "";

        for(int i=0; i<this.texto.length; i++){
            resultado = resultado + this.texto[i] + " ";
        }
        return resultado;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Tracinhos t = (Tracinhos)obj;
        if(this.texto != t.texto) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;

        ret = ret * 2 + Arrays.hashCode(this.texto);

        if(ret<0) ret=-ret;

        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception
    {
        if(t==null) throw new Exception("Modelo ausente");

        this.texto=t.texto;
    }

    @Override
    public Object clone ()
    {
        Tracinhos ret=null;

        try{
            ret = new Tracinhos(this);
        }
        catch (Exception erro){}

        return ret;
    }
}
