import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private final static Random rand = new Random();

    public static void main(String[] args) {
        List<Wagon> wagons = generateWagon(generateSpeed());

        List<Wagon> validWagons = new ArrayList<>();
        List<Wagon> invalidWagons = new ArrayList<>();

        for (Wagon wagon : wagons) {
            String validation = wagon.isStringValid();
            if (validation.equals("Valid")) {
                validWagons.add(wagon);
            } else {
                System.out.println(validation);
                invalidWagons.add(wagon);
            }
        }
    }

    private static List<Speed> generateSpeed() {
        List<Speed> speeds = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            speeds.add(new Speed(
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200),
                    (short) rand.nextInt(200)));
        }
        return speeds;
    }

    private static List<Wagon> generateWagon(List<Speed> speeds) {
        List<Wagon> wagons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int index = rand.nextInt(speeds.size());
            short[] wagonSpeeds = new short[]{
                    (short) rand.nextInt(50),
                    (short) rand.nextInt(100),
                    (short) rand.nextInt(50)
            };
            int indexAlternativeSpeedLimit = rand.nextInt(4, 9);
            wagons.add(new Wagon(speeds.get(index), wagonSpeeds, indexAlternativeSpeedLimit));
        }
        for (int i = 0; i < 10; i++) {
            int index = rand.nextInt(speeds.size());
            short[] wagonSpeeds = new short[]{
                    (short) rand.nextInt(50),
                    (short) rand.nextInt(100),
                    (short) rand.nextInt(50)
            };

            wagons.add(new Wagon(speeds.get(index), wagonSpeeds));
        }
        return wagons;
    }
}