package br.javacv.form.operacoes;

import br.javacv.main.Visao;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Aula1 implements IExecutaOperacao {

    private Visao visao = new Visao();


    public List<BufferedImage> perform(int[][][] imagemMatrizOriginal) {
		List<BufferedImage> images = new ArrayList<BufferedImage>();


        images.add(visao.matrizToImagemRGB(imagemMatrizOriginal));

        int[][] imagemCinza = visao.tonsCinzaMedia(imagemMatrizOriginal);
        images.add(visao.matrizToImagem(imagemCinza));

//        int[][] sobelH = visao.fpaSobel(imagemCinza);
//        images.add(visao.matrizToImagem(sobelH));

//        int[] histograma = visao.histograma(imagemCinza);
//        for (int i : histograma)
//            System.out.println(i);

        double[] histogramaN = visao.histogramaNormalizado(imagemCinza);
        for (double i : histogramaN)
            System.out.println(i);

        int[][] histEq = visao.histogramaEqualizar(imagemCinza);
        images.add(visao.matrizToImagem(histEq));




		return images;
    }

}
