package frc.commons;

public class Conversions {

    /**
     * @param positionCounts CANCoder Position Counts
     * @param gearRatio Gear Ratio between CANCoder and Mechanism
     * @return Degrees of Rotation of Mechanism
     */
    public static double CANcoderToDegrees(double positionCounts, double gearRatio) {
        return positionCounts * (360.0 / (gearRatio * 4096.0));
    }

    /**
     * @param degrees Degrees of rotation of Mechanism
     * @param gearRatio Gear Ratio between CANCoder and Mechanism
     * @return CANCoder Position Counts
     */
    public static double degreesToCANcoder(double degrees, double gearRatio) {
        return degrees / (360.0 / (gearRatio * 4096.0));
    }

    /**
     * @param counts Falcon Position Counts
     * @param gearRatio Gear Ratio between Falcon and Mechanism
     * @return Degrees of Rotation of Mechanism
     */
    public static double falconToDegrees(double positionCounts, double gearRatio) {
        return positionCounts * (360.0 / (gearRatio * 2048.0));
    }

    /**
     * @param degrees Degrees of rotation of Mechanism
     * @param gearRatio Gear Ratio between Falcon and Mechanism
     * @return Falcon Position Counts
     */
    public static double degreesToFalcon(double degrees, double gearRatio) {
        return degrees / (360.0 / (gearRatio * 2048.0));
    }

    public static double RotationsToDegrees(double RPM, double gearRatio){
        return RPM * (360.0 / (gearRatio));
    }
    
    public static double DegreesToRotations(double degrees, double gearRatio){
        return degrees / (360.0 / (gearRatio));
    }

    /**
     * @param velocityCounts Falcon Velocity Counts
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon RPM)
     * @return RPM of Mechanism
     */
    public static double falconToRPM(double velocityCounts, double gearRatio) {
        double motorRPM = velocityCounts * (600.0 / 2048.0);        
        double mechRPM = motorRPM / gearRatio;
        return mechRPM;
    }

    /**
     * @param RPM RPM of mechanism
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon RPM)
     * @return RPM of Mechanism
     */
    public static double RPMToFalcon(double RPM, double gearRatio) {
        double motorRPM = RPM * gearRatio;
        double sensorCounts = motorRPM * (2048.0 / 600.0);
        return sensorCounts;
    }

    /**
     * @param velocitycounts Falcon Velocity Counts
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon MPS)
     * @return Falcon Velocity Counts
     */
    public static double falconToMPS(double velocitycounts, double circumference, double gearRatio){
        double wheelRPM = falconToRPM(velocitycounts, gearRatio);
        double wheelMPS = (wheelRPM * circumference) / 60;
        return wheelMPS;
    }

    /**
     * @param velocity Velocity MPS
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Mechanism (set to 1 for Falcon MPS)
     * @return Falcon Velocity Counts
     */
    public static double MPSToFalcon(double velocity, double circumference, double gearRatio){
        double wheelRPM = ((velocity * 60) / circumference);
        double wheelVelocity = RPMToFalcon(wheelRPM, gearRatio);
        return wheelVelocity;
    }

    /**
     * @param positionCounts Falcon Position Counts
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Wheel
     * @return Meters
     */
    public static double falconToMeters(double positionCounts, double circumference, double gearRatio){
        return positionCounts * (circumference / (gearRatio * 2048.0));
    }

    /**
     * @param meters Meters
     * @param circumference Circumference of Wheel
     * @param gearRatio Gear Ratio between Falcon and Wheel
     * @return Falcon Position Counts
     */
    public static double MetersToFalcon(double meters, double circumference, double gearRatio){
        return meters / (circumference / (gearRatio * 2048.0));
    }

    public static double RotationsToMeters(double Rotations, double circumference, double gearRatio){
        return Rotations * (circumference / (gearRatio));
    }

    public static double metersToRotations(double meters, double circumference, double gearRatio){
        return meters / (circumference / (gearRatio));
    }

    public static double RPMtoMPS(double RPM, double circumference, double gearRatio){
        double wheelMPS = (RPM * circumference) / 60.0;
        return wheelMPS;
    }

    public static double MPStoRPM(double MPS, double circumference, double gearRatio){
        double wheelRPM = (MPS * 60.0) / circumference;
        return wheelRPM;
    }

    public static double MPStoRPS(double MPS, double circumference, double gearRatio){
        double wheelRPS = MPS / circumference;
        return wheelRPS;
    }

    public static double RPStoMPS(double RPS, double circumference, double gearRatio){
        double wheelMPS = (RPS * circumference);
        return wheelMPS;
    }

    
}
    
