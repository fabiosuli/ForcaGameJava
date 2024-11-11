import javax.naming.ldap.Control;

public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        // verifica se qtdMax fornecida n?o ? positiva, lan?ando
        // uma exce??o.
        // armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax<0) throw new Exception ("Quantidade invalida");

        this.qtdMax=qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja ? igual a this.qtdMax,
        // lan?ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou ent?o false, caso contrario.
        /*
        if (this.qtdErr==this.qtdMax)
            return true;
        else
            return false;
        */

        return this.qtdErr==this.qtdMax;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass() != obj.getClass()) return false;

        ControladorDeErros c = (ControladorDeErros) obj;
        if(this.qtdMax != c.qtdMax) return false;
        if(this.qtdErr != c.qtdErr) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;

        ret = ret * 2 + Integer.hashCode(this.qtdMax);
        ret = ret * 2 + Integer.hashCode(this.qtdErr);

        if(ret<0) ret=-ret;

        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception
    {
        if(c==null) throw new Exception("Modelo ausente");

        this.qtdErr = c.qtdErr;
        this.qtdMax = c.qtdMax;
    }

    @Override
    public Object clone ()
    {
        ControladorDeErros ret=null;

        try{
            ret = new ControladorDeErros(this);
        }
        catch (Exception erro){}

        return ret;
    }
}
