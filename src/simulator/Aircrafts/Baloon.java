package simulator.Aircrafts;

import weather.Simulator;
import weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String climate = weatherTower.getWeather(this.coordinates);

        if ("RAIN".equals(climate)) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            Simulator.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") is in a rainy climate");
        } else if ("SUN".equals(climate)) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            Simulator.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") is in a humid climate");
        } else if ("SNOW".equals(climate)) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            Simulator.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") is in a white climate");
        } else if ("FOG".equals(climate)) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() + 2);
            Simulator.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") can't see jack!");
        }

        if (this.coordinates.getHeight() == 0) {
            Simulator.writer.println(this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Simulator.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
     /*   ....this.getClass().getSimpleName() gets whole class, then name of class */
        Simulator.writer.println("Tower says: " + this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ") register to weather tower");
    }
}

