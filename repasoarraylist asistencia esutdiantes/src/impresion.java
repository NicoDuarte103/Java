import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class impresion {

    public impresion(JTable tabla,String archivo) throws IOException{

        BufferedImage imagen = new BufferedImage(tabla.getWidth(),tabla.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagen.createGraphics();
        g2d.setColor(Color.white);
        g2d.fillRect(0,0,tabla.getWidth(),tabla.getHeight());
        tabla.print(g2d);

        ImageIO.write(imagen,"png",new File(archivo));


    }
}
