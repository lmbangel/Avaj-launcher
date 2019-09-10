package simulator.Aircrafts;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type.equalsIgnoreCase("helicopter"))
            return new Helicopter(name, coordinates);
        else if (type.equalsIgnoreCase("jetplane"))
            return new JetPlane(name, coordinates);
        else if (type.equalsIgnoreCase("baloon"))
            return new Baloon(name, coordinates);
        else {
            System.out.println("Incorrect aircraft detected");
            return null;
        }
    }
}
