package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START
		
		for(int i = 0; i < gpspoints.length - 1; i++) {
			distance += GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		}

		return Math.round(distance);

		// TODO - SLUTT

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO - START
		for(int i = 1; i < gpspoints.length; i++) {
			if(gpspoints[i].getElevation() > gpspoints[i-1].getElevation()) {
				elevation += gpspoints[i].getElevation() - gpspoints[i-1].getElevation();
			}
		}
		return elevation;

		// TODO - SLUTT
	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int start = gpspoints[0].getTime();
		
		int slutt = gpspoints[gpspoints.length - 1].getTime();
		
		int sammenlagt = slutt - start;
		
		return sammenlagt;

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		double[] averageSpeeds = new double[gpspoints.length - 1];
		// TODO - START		// OPPGAVE - START
		
		for(int i = 0; i < gpspoints.length - 1; i++) {
			averageSpeeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		
		return averageSpeeds;

		// TODO - SLUTT

	}
	
	public double maxSpeed() {
		
		double maxspeed = speeds()[0];
		
		// TODO - START
		
		for (double d : speeds()) {
			if (d > maxspeed) {
				maxspeed = d;
			}
		}
		
		return maxspeed;
		
		// TODO - SLUTT
		
	}

	public double averageSpeed() {

		double average = 0;
		
		// TODO - START
		
		average = (totalDistance()/totalTime()) * 3.6;
		
		return average;
		
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO - START
		if (speedmph < 10) {
			met = 4.0;
		}else if(speedmph > 10 && speedmph < 12) {
			met = 6.0;
		}else if(speedmph > 12 && speedmph < 14) {
			met = 8.0;
		}else if(speedmph > 14 && speedmph < 16) {
			met = 10.0;
		}else if(speedmph > 16 && speedmph < 20) {
			met = 12.0;
		}else {
			met = 16.0;
		}
		
		kcal = met * weight * secs/3600.0;
		
		return kcal;

		// TODO - SLUTT
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
		for(int i = 0; i < gpspoints.length - 1; i++) {
			totalkcal = kcal(weight, totalTime(), GPSUtils.speed(gpspoints[i], gpspoints[i+1]) );
		}
		
		return totalkcal;

		// TODO - SLUTT
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START
		
		String[] statistics = {
				"Total Time     : " + GPSUtils.formatTime(totalTime()),
				"Total distance : " + GPSUtils.formatDouble(totalDistance()/1000) + " km",
				"Total elevation:" + GPSUtils.formatDouble(totalElevation()) + " m",
				"Max speed      : " + GPSUtils.formatDouble(maxSpeed()) + " km/t",
				"Average speed  : " + GPSUtils.formatDouble(averageSpeed()) + " km/t",
				"Energy         : " + GPSUtils.formatDouble(totalKcal(WEIGHT)) + " kcal"
		
		};
		
		for (int i = 0; i < statistics.length; i++) {
			System.out.println(statistics[i]);;
		}
		

		System.out.println("==============================================");
		
		// TODO - SLUTT
		
	}

}
