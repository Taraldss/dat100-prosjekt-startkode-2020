package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START

		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] latitudes = new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++ ) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		
		return latitudes;
		
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] longitudes = new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++ ) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		double deltaLatitude = toRadians(latitude2 - latitude1);
		double deltaLongitude = toRadians(longitude2 - longitude1);
		
		
		double a = pow(sin(deltaLatitude/2), 2) + cos(toRadians(latitude1))  * cos(toRadians(latitude2)) * 
				pow(sin(deltaLongitude/2), 2);
		
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		
		
		d = R * c;
		
		
		return round(d);
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed; //km/h
		
		// TODO - START
		double d = distance(gpspoint1, gpspoint2);
		secs = gpspoint2.getTime() - gpspoint1.getTime();
		
		double speedMs = d/secs;
		
		speed = (speedMs * 3600)/1000; //km/h

		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int timer= secs/60;
		
		int minutter = timer % 60;
		
		int sekunder = secs % 60;
		
		timer = timer/60;
		
		String timeStr = String.format("%02d", timer);
		String minuttStr = String.format("%02d", minutter);
		String sekundStr = String.format("%02d", sekunder);
		
		timestr = String.format("  %s%s%s%s%s", timeStr, TIMESEP, minuttStr, TIMESEP, sekundStr);
		
		return timestr;
		
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = "";
		
		d *= 100;
		
		d = Math.round(d);
		
		d /= 100;

		for(int i = String.valueOf(d).length(); i < TEXTWIDTH; i++ ) {
			str += " ";
		}
		
		str += d;

		return str;

		// TODO - SLUTT
		
	}
}
