package simulator.Aircrafts;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.id = nextId();
        this.coordinates = coordinates;
    }

    private long nextId(){ return ++idCounter; }
}
