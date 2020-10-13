package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;

public class GPSPoint {
	
	//objektvariabler
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {
		//kontruktør som gir verdi til objektvariabler
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		
	}

	//Get/Set metoder for objektvariablane
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
				
		this.time = time;

	}

	public double getLatitude() {
		
		return latitude;
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
		
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
		
	}
	//String representasjon av et GPSpunkt
	public String toString() {
		
		String str;
		
		// TODO - start
		
		str = time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
		
		return str;

		// TODO - slutt
		
	}
}
