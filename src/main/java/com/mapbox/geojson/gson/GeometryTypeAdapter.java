package com.mapbox.geojson.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.CoordinateContainer;
import com.mapbox.geojson.Geometry;
import java.io.IOException;

@Deprecated
public class GeometryTypeAdapter extends TypeAdapter<Geometry> {
    public void write(JsonWriter out, Geometry value) throws IOException {
        out.beginObject();
        out.name("type").value(value.type());
        if (value.bbox() != null) {
            out.name("bbox").jsonValue(value.bbox().toJson());
        }
        if (value instanceof CoordinateContainer) {
            out.name("coordinates").jsonValue(((CoordinateContainer) value).coordinates().toString());
        }
        out.endObject();
    }

    public Geometry read(JsonReader in2) throws IOException {
        return null;
    }
}
