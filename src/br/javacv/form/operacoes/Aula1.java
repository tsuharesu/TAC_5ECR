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

        int[][][] skinRgb1 = visao.skinRgb1(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinRgb1));

        int[][][] skinRgb2 = visao.skinRgb2(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinRgb2));

        int[][][] skinRgb3 = visao.skinRgb3(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinRgb3));

        int[][][] skinRgb = visao.skinRgb(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinRgb));

        int[][][] skinYCbCr1 = visao.skinYCbCr1(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinYCbCr1));

        int[][][] skinYCbCr2 = visao.skinYCbCr2(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinYCbCr2));

        int[][][] skinYCbCr = visao.skinYCbCr(imagemMatrizOriginal);
        images.add(visao.matrizToImagemRGB(skinYCbCr));
               
                
                               
		
		return images;
    }

}
