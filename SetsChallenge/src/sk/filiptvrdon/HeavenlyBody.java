package sk.filiptvrdon;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final String bodyType;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, String bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getBodyType() {
        return bodyType;
    }

    public boolean addSatellite(HeavenlyBody satellite){
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    final public boolean equals(Object obj) {
        // set of heavenly bodies can contain elements with the same name but different designation //
        if (this == obj){
            return true;
        }

        if (obj == null){
            return false;
        }

        if  (!(obj instanceof HeavenlyBody)) {
            return false;
        }

        if (!((HeavenlyBody) obj).getBodyType().equals(this.getBodyType())){
            return false;
        }

        return Objects.equals(this.name, ((HeavenlyBody) obj).getName());

    }

    @Override
    final public int hashCode() {
        return Objects.hash(this.name, this.orbitalPeriod, ((this.satellites.size() > 0 ) ? this.satellites : 0));
    }

    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
