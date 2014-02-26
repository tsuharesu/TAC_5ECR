package br.javacv.form.operacoes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import br.javacv.main.Visao;

public class Aula1 implements IExecutaOperacao {

	private Visao visao = new Visao();


	public List<BufferedImage> perform(int[][][] imagemMatrizOriginal) {
		List<BufferedImage> images = new ArrayList<BufferedImage>();

//        images.add(  visao.matrizToImagemRGB( imagemMatrizOriginal )  );

        int[][] cinza = visao.tonsCinzaIntensidade(imagemMatrizOriginal);

        images.add(visao.matrizToImagem(cinza));

        int[][] fpaHorizontal = visao.fpaHorizontal(cinza);
        images.add(visao.matrizToImagem(fpaHorizontal));

        int[][] fpaVertical = visao.fpaVertical(cinza);
        images.add(visao.matrizToImagem(fpaVertical));

        int[][] fpaSobel = visao.fpaSobel(cinza);
        images.add(visao.matrizToImagem(fpaSobel));

		return images;
    }

}
