public class Speed {
    private final short speedLimit1, speedLimit2, speedLimit3,
            speedLimit4, speedLimit5, speedLimit6, speedLimit7, speedLimit8;

    public Speed(short speedLimit1, short speedLimit2, short... speedLimits) {
        if (speedLimit1 < 0 || speedLimit2 < 0) {
            throw new IllegalArgumentException("speedLimits must not be negative");
        }

        for (short speedLimit: speedLimits) {
            if (speedLimit < -1) {
                throw new IllegalArgumentException("speedLimits must be positive or -1 (for unset values)");
            }
        }

        this.speedLimit1 = speedLimit1;
        this.speedLimit2 = speedLimit2;
        speedLimit3 = speedLimits.length > 0 ? speedLimits[0] : -1;
        speedLimit4 = speedLimits.length > 1 ? speedLimits[1] : -1;
        speedLimit5 = speedLimits.length > 2 ? speedLimits[2] : -1;
        speedLimit6 = speedLimits.length > 3 ? speedLimits[3] : -1;
        speedLimit7 = speedLimits.length > 4 ? speedLimits[4] : -1;
        speedLimit8 = speedLimits.length > 5 ? speedLimits[5] : -1;
    }

    public short getSpeedLimitByIndex(int index) {
        return switch (index) {
            case 1 -> speedLimit1;
            case 2 -> speedLimit2;
            case 3 -> speedLimit3;
            case 4 -> speedLimit4;
            case 5 -> speedLimit5;
            case 6 -> speedLimit6;
            case 7 -> speedLimit7;
            case 8 -> speedLimit8;
            default -> -1;
        };
    }


}
