package simulator.Aircrafts;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height){
        this.longitude = (longitude > 0) ? longitude : 0;
        this.latitude = (latitude > 0) ? latitude : 0;
        this.height = (height > 0 && height <= 100) ? height : (height < 0) ? 0 : 100;
    }

    public int getLongitude(){ return longitude; }

    public int getLatitude() { return latitude; }

    public int getHeight() { return height; }
}
