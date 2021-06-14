package src.gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loadImage(String filePath){
        try {
            return ImageIO.read(ImageLoader.class.getResource(filePath));
        }catch (IOException e){
            System.out.println("Não pode carregar a imagem do diretório!" + filePath);
            System.exit(1);
        }

        return null;
    }
}
