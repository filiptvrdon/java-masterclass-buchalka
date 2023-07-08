package org.example;

enum Geometry {POINT, LINE, POLYGON};
enum Color {RED, GREEN, BLUE};
enum Marker {CIRCLE, SQUARE, TRIANGLE};
enum LineMarker {DASHED, DOTTED, SOLID};



public interface Mappable {

    String JSON_PROPERTY = "\"properties\": {%s}";

    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJSON(){
        return """
                "type: "%s", "label": %s, "marker": %s
                """.formatted(getShape(), getLabel(), getMarker());
    }

    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }


}
