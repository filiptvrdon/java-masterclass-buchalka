package sk.filiptvrdon;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, "planet");
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if (!(satellite instanceof Moon)){
            return false;
        }
        return super.addSatellite(satellite);
    }
}
