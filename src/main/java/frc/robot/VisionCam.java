package frc.robot;

import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Transform2d;

public class VisionCam {

//var camera = new PhotonCamera("newCam");

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
Transform2d pose = target.getCameraToTarget();
List<TargetCorner> corners = target.getCorners();

}

