import java.util.Arrays;

public class Wagon {
    private final Speed speed;
    private final short[] setSpeed;
    private final int indexAlternativeSpeedLimit;

    public Wagon(Speed speed, short[] setSpeed, int indexAlternativeSpeedLimit) {
        if (speed == null) {
            throw new IllegalArgumentException("Speed cannot be null");
        }
        if (setSpeed == null || setSpeed.length != 3) {
            throw new IllegalArgumentException("setSpeed must have length 3");
        }
        if (indexAlternativeSpeedLimit < 1 || indexAlternativeSpeedLimit > 8) {
            throw new IllegalArgumentException("indexAlternativeSpeedLimit must be between 1 and 8");
        }

        this.speed = speed;
        this.setSpeed = Arrays.copyOf(setSpeed, setSpeed.length);
        this.indexAlternativeSpeedLimit = indexAlternativeSpeedLimit;
    }

    public Wagon(Speed speed, short[] speedLimits) {
        this(speed, speedLimits, 1);
    }

    public String isStringValid() {
        for (int i = 0; i < setSpeed.length; i++) {
            short currentSpeed = setSpeed[i];

            if (currentSpeed == -1)
                continue;

            short limit;
            int number;
            if (i == 0) {
                limit = speed.getSpeedLimitByIndex(indexAlternativeSpeedLimit);
                number = indexAlternativeSpeedLimit;
            } else {
                limit = speed.getSpeedLimitByIndex(i + 1);
                number = i + 1;
            }

            if (limit != -1 && limit < currentSpeed) {
                return String.format(this + " Invalid: Speed%d (%d) > Limit%d (%d) by %d",
                        i+1, currentSpeed, number, limit, currentSpeed - limit);
            }
        }
        return "Valid";
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "speed=" + speed +
                ", setSpeed=" + Arrays.toString(setSpeed) +
                ", indexAlternativeSpeedLimit=" + indexAlternativeSpeedLimit +
                '}';
    }
}
