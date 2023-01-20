package frc.robot.subsystems;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSource;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.commands.SetRaspberryPiPipeline;

public class VisionCam {

//var camera = new PhotonCamera("newCam");
private static final double CAMERA_HEIGHT_METERS = 0;

private static final double TARGET_HEIGHT_METERS = 0;

private static final double CAMERA_PITCH_RADIANS = 0;

PhotonCamera camUS = new PhotonCamera("spicyNoodles"); //change string to match name of camera

 // Query the latest result from PhotonVision
 PhotonPipelineResult result = camUS.getLatestResult();

 // Check if the latest result has any targets.
boolean hasTargets = result.hasTargets();

// Get a list of currently tracked targets.
List<PhotonTrackedTarget> targets = result.getTargets();

// Get the current best target.
PhotonTrackedTarget target = result.getBestTarget();



 // Get information from target.
double yaw = target.getYaw();
double pitch = target.getPitch();
double area     = target.getArea();
double skew = target.getSkew();
//Transform2d pose = target.getCameraToTarget();
List<TargetCorner> corners = target.getDetectedCorners();

double range =
PhotonUtils.calculateDistanceToTargetMeters(
        CAMERA_HEIGHT_METERS,
        TARGET_HEIGHT_METERS,
        CAMERA_PITCH_RADIANS,
        Units.degreesToRadians(result.getBestTarget().getPitch()));

public void addShuffleboardTab() {
    

    ShuffleboardTab piTab = Shuffleboard.getTab("RaspberryPi");

    ShuffleboardTab visionCamTab = Shuffleboard.getTab("VisionCam");

    ShuffleboardLayout layout = visionCamTab.getLayout("Raspberry PI", BuiltInLayouts.kList).withPosition(0, 0).withSize(3, 4);

    // ShuffleboardLayout pipelineLayout = piTab.getLayout("Pipeline", BuiltInLayouts.kList).withPosition(0, 0).withSize(2,
    // 2); 

    UsbCamera nileRiver = new UsbCamera("LifeCam HD-3000", "http://10.9.48.11:5800/");
    
    Shuffleboard.selectTab("VisionCam");

   //pipelineLayout.addString("Pipeline Runner", () -> currentRunner.getName());
    layout.add("LoadingBayTarget", new SetRaspberryPiPipeline(this, PipelineRunner.getName()));

    VideoSource processedVideo = new HttpCamera("Processed", "http://10.9.48.11:5800/");

    piTab.add("WebCam", nileRiver).withWidget(BuiltInWidgets.kCameraStream).withPosition(2, 0).withSize(4,
        3);

}

// UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
// camera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 120);
// new Thread(() -> {
//     CvSink cvSink = CameraServer.getInstance().getVideo();
//     CvSource outputStream = CameraServer.getInstance().putVideo("camera stream", 320, 240);
//     Mat source = new Mat();
//     while(!Thread.interrupted()) {
//         cvSink.grabFrame(source);
//         outputStream.putFrame(source);
//     }
// }).start();
}

