package org.example;

enum UtilityType {ELECTRICITY, GAS, WATER, SEWER, INTERNET};

public class UtilityLine implements Mappable{

    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return switch (type){
            case ELECTRICITY -> Color.RED + " " + LineMarker.DASHED;
            case GAS -> Color.GREEN + " " + LineMarker.DOTTED;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            case SEWER -> Color.BLUE + " " + LineMarker.DASHED;
            case INTERNET -> Color.GREEN + " " + LineMarker.SOLID;
            default -> Color.RED + " " + LineMarker.DOTTED;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                "name": "%s", "utility type": "%s"
                """.formatted(name, type);
    }
}
