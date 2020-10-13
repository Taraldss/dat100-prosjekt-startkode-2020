package no.hvl.dat100ptc.oppgave2;


import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		//konstruktør for klassen
		
		this.gpspoints = new GPSPoint[n];
		this.antall = 0;

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		
		//Setter inn et gpspunkt i en gpspunkt-tabell gitt av objektvariabel antall.
		boolean inserted = false;

		// TODO - START
		if(antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
		}else {
			inserted = false;
		}
		
		return inserted;

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		//konverterer data og kaller insertGPS metoden.
		GPSPoint gpspoint;
		
		
		// TODO - START
		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		
		return insertGPS(gpspoint);
		// TODO - SLUTT
		
	}

	public void print() {
		//utskrift av gpsdata.
		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		for(int i = 0; i < gpspoints.length; i++) {
			System.out.println(gpspoints[i].toString());
		}

		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
