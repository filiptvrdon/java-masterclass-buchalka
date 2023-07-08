package org.example;

enum UsageType {RESIDENTIAL, COMMERCIAL, INDUSTRIAL, GOVERNMENT, ENTERTAINMENT};

public class Building implements Mappable{

    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage){
            case RESIDENTIAL -> Color.BLUE + " " + Marker.SQUARE;
            case COMMERCIAL -> Color.GREEN + " " + Marker.CIRCLE;
            case INDUSTRIAL -> Color.RED + " " + Marker.TRIANGLE;
            case GOVERNMENT -> Color.BLUE + " " + Marker.TRIANGLE;
            case ENTERTAINMENT -> Color.GREEN + " " + Marker.SQUARE;
            default -> Color.RED + " " + Marker.CIRCLE;
        };
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                "name": "%s", "usage": "%s"
                """.formatted(name, usage);
    }
}
