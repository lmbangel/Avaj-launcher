package weather;

import simulator.Aircrafts.AircraftFactory;
import java.io.*;
import static java.lang.System.exit;

public class ReadWriteRun{

    static int numSim;
    public static void Read(AircraftFactory aircraftFactory, WeatherTower weatherTower, BufferedReader BuffRead) throws IOException{

        String line;
        for (int i=0; ((line = BuffRead.readLine()) != null); i++)
            if (i == 0) {

                numSim = Integer.parseInt(line);
                if (line.isEmpty() || numSim <= 0 || Character.isLetter(numSim)){
                    System.out.println("First Line Must Be A Positive Integer Greater Than 0");
                    exit(-1);
                }
            } else {
                String[] variables = line.split(" ");
                /*              .........Creating an aircraft..........                    */
                if (variables.length == 5)
                    aircraftFactory.newAircraft(variables[0], variables[1], Integer.parseInt(variables[2]), Integer.parseInt(variables[3]),
                            Integer.parseInt(variables[4])).registerTower(weatherTower);
                else {
                    System.out.println("Lines Must Contain Exactly 5 Columns");
                    exit(-1);
                }
            }
        while ((numSim--) > 0)
            weatherTower.changeWeather();
        Simulator.writer.close();
    }
}
