public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		if(texto == null || texto.isEmpty()){
            throw new Exception("Texto não pode ser nulo ou vázio");
        }
		this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        int cont = 0;
        for(int i=0; i < this.texto.length(); i++){
            if(this.texto.charAt(i) == letra){
                cont ++;
            }
        }
        return cont;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception {
        int cont = 0;
        for (int pos = 0; pos < this.texto.length(); pos++) {
            if (this.texto.charAt(pos) == letra) {
                if (cont == i) {
                    return pos;
                }
                cont++;
            }
        }
        throw new Exception("Não há a ocorrência " + i + " da letra " + letra);
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Palavra p = (Palavra)obj;
        if(this.texto != p.texto) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + String.valueOf(this.texto).hashCode();

        if(ret<0) ret = -ret;

        return ret;
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
