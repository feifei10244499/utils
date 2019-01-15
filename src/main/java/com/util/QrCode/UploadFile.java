package com.util.QrCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UploadFile {

    public static void main(String[] arg){
        uploadFile("e:/abc.jpg");
    }

    public static void uploadFile(String url)   {
        try {
            BufferedImage waterImage = ImageIO.read(new File(url));
            int h = 120;
            int w = h;
            BufferedImage to = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = to.createGraphics();
            to = g2d.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
            g2d.dispose();
            g2d = to.createGraphics();
            Image from = waterImage.getScaledInstance(w, h, BufferedImage.SCALE_AREA_AVERAGING);
            g2d.drawImage(from, 0, 0, null);
            g2d.dispose();
            File outStream = new File("e:/test/z.jpg");
            //查看压缩后的水印图
            ImageIO.write(to, "png", outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
