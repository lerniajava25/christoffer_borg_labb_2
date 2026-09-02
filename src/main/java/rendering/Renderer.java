package rendering;

import geometry.HitInfo;
import math.Ray;
import math.Vector3;
import scene.Scene;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Renderer {
    private final int width;
    private final int height;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void render(Scene scene) throws IOException {
        Vector3 origin = new Vector3(0, 0, 0);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double screenX = (x - width /2.0) / (width / 2.0);
                double screenY = (height / 2.0 - y) / (height / 2.0);
                Vector3 direction = new Vector3(screenX, screenY, 1);
                Ray ray = new Ray(origin, direction);
                HitInfo hit = scene.hit(ray);
                Color pixelColor;
                if (hit == null) {
                    pixelColor = Color.BLACK;
                }
                else {
                    pixelColor = hit.color();
                }
                int rgb = pixelColor.getRed() << 16 | pixelColor.getGreen() << 8 | pixelColor.getBlue();
                image.setRGB(x, y, rgb);
            }
        }
        File outputFile = new File("renders/render.png");
        ImageIO.write(image, "png", outputFile);
    }
}
