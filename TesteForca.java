public class TesteForca {
    public static void main(String[] args) {

        System.out.println("Testando a classe Palavra");
        try {
            Palavra palavra = new Palavra("forca");
            System.out.println("Quantidade de 'a': " + palavra.getQuantidade('a'));
            System.out.println("Posição da 1ª ocorrência de 'a': " + palavra.getPosicaoDaIezimaOcorrencia(0, 'a'));
            System.out.println("Tamanho da palavra: " + palavra.getTamanho());
            System.out.println("Palavras são iguais: " + palavra.equals(new Palavra("forca")));
            System.out.println("HashCode da palavra: " + palavra.hashCode());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n-------------------------\n");

        System.out.println("Testando a classe Teclado");
        try {
            System.out.print("Digite um número inteiro: ");
            int numero = Teclado.getUmInt();
            System.out.println("Número digitado: " + numero);

            System.out.print("Digite um caractere: ");
            char caractere = Teclado.getUmChar();
            System.out.println("Caractere digitado: " + caractere);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n-------------------------\n");

        System.out.println("Testando a classe Tracinhos");
        try {
            Tracinhos tracinhos = new Tracinhos(5);
            tracinhos.revele(1, 'f');
            System.out.println("Tracinhos após revelar a letra 'f': " + tracinhos);
            System.out.println("Ainda com tracinhos: " + tracinhos.isAindaComTracinhos());
            Tracinhos cloneTracinhos = (Tracinhos) tracinhos.clone();
            System.out.println("Clone de tracinhos: " + cloneTracinhos);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n-------------------------\n");

        System.out.println("Testando a classe ControladorDeLetrasJaDigitadas");
        try {
            ControladorDeLetrasJaDigitadas controladorLetras = new ControladorDeLetrasJaDigitadas();
            controladorLetras.registre('a');
            System.out.println("Letra 'a' registrada: " + controladorLetras.isJaDigitada('a'));
            controladorLetras.registre('b');
            System.out.println("Letra 'b' registrada: " + controladorLetras.isJaDigitada('b'));
            System.out.println("Letra 'c' não registrada: " + controladorLetras.isJaDigitada('c'));
            System.out.println("Letras digitadas: " + controladorLetras.toString());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n-------------------------\n");

        System.out.println("Testando a classe ControladorDeErros");
        try {
            ControladorDeErros controladorErros = new ControladorDeErros(3);
            controladorErros.registreUmErro();
            System.out.println("Erro registrado. Total de erros: " + controladorErros.toString());
            controladorErros.registreUmErro();
            System.out.println("Erro registrado. Total de erros: " + controladorErros.toString());
            System.out.println("Atingiu o limite de erros? " + controladorErros.isAtingidoMaximoDeErros());
            controladorErros.registreUmErro();
            System.out.println("Erro registrado. Total de erros: " + controladorErros.toString());
            System.out.println("Atingiu o limite de erros? " + controladorErros.isAtingidoMaximoDeErros());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n-------------------------\n");

        System.out.println("Todos os testes foram executados.");
    }
}
