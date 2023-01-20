package frc.robot.commands;
import frc.robot.subsystems.VisionCam;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PipelineRunner;

public class SetRaspberryPiPipeline extends CommandBase {
    private PipelineRunner runner;
    private VisionCam raspPi;

    public SetRaspberryPiPipeline(VisionCam raspPi, PipelineRunner runner) {
        this.raspPi = raspPi;
        this.runner = runner;
        addRequirements(raspPi);
    }

    private void addRequirements(VisionCam raspPi2) {
    }
}
