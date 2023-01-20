package frc.robot.subsystems;
import edu.wpi.first.wpilibj.util.Color8Bit;
import java.lang.String;

public enum PipelineRunner {
    


    public final String name;
    private final Color8Bit color;

    /**
     * Constructs the enumeration.
     * 
     * @param name  The name of the pipeline.
     * @param color The color of the LEDs.
     */
    PipelineRunner(String name, Color8Bit color) {
      this.name = name;
      this.color = color;
    }

    public static String getName() {
        return this.runner;
    }
}