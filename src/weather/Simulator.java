 package weather;

import simulator.Aircrafts.AircraftFactory;
import java.io.*;

public class Simulator {

    public static PrintWriter writer;

    public static void main(String[] args)
    {
        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        /*.. Try Open My file */
        try {
            BufferedReader BuffRead = new BufferedReader(new FileReader(args[0]));
            /* ...........File writer........... */
            writer =  new PrintWriter(new File("Simulation.txt"));
            ReadWriteRun.Read(aircraftFactory, weatherTower, BuffRead);
        }
        catch(Exception e){
            System.out.println("Error With The  Input File");
        }
    }
}

