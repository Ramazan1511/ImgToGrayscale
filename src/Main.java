import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            File file = new File("your_input_file_path");
            BufferedImage source = ImageIO.read(file);

            BufferedImage result = new BufferedImage(source.getWidth(),source.getHeight(),source.getType());

            for(int x = 0; x < source.getWidth(); x++){
                for(int y = 0; y < source.getHeight(); y++){
                    Color color = new Color(source.getRGB(x,y));

                    int blue = color.getBlue();
                    int red = color.getRed();
                    int green = color.getGreen();

                    int grey = (int) (red * 0.299 + green * 0.587 + blue * 0.114);

                    Color newColor = new Color(grey, grey, grey);

                    result.setRGB(x,y, newColor.getRGB());

                }
            }
            File output = new File("your_output_file_path");
            ImageIO.write(result,"jpg",output);

        }
        catch (IOException e){
            System.out.println("File not found or something else");
        }
    }
}