package br.javacv.main;

import br.javacv.form.Formulario;
import br.javacv.form.operacoes.Aula1;

public class Imagem {

    public static void main(String[] args) {

    	int[][][] matrizOriginal = new Visao().arquivoMatrizRGB("files/imagem1.jpg");

        Formulario f = new Formulario();

        f.exibir(new Aula1(), matrizOriginal);


    }
}
