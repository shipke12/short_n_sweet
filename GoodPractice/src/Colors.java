import java.util.Scanner;

public class Colors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("First color: (0-255)rgb order please!");
        int red1 = in.nextInt();
        int green1 = in.nextInt();
        int blue1 = in.nextInt();

        System.out.println("Second color: (0-255)rgb order please!");
        int red2 = in.nextInt();
        int green2 = in.nextInt();
        int blue2 = in.nextInt();

        System.out.println("What weight would you like on the first color? (0-1) rgb!");
        double color2Weight = in.nextDouble();

        double red1Intensity = red1*(1 - color2Weight);
        double green1Intensity = green1*(1 - color2Weight);
        double blue1Intensity = blue1*(1 - color2Weight);

        double red2Intensity = red2*color2Weight;
        double green2Intensity = green2*color2Weight;
        double blue2Intensity = blue2*color2Weight;

        int redFinal = (int) (red1Intensity + red2Intensity);
        int greenFinal = (int) (green1Intensity + green2Intensity);
        int blueFinal = (int) (blue1Intensity + blue2Intensity);

        System.out.printf("Red = %d, Green = %d, Blue = %d", redFinal, greenFinal, blueFinal);
    }
}