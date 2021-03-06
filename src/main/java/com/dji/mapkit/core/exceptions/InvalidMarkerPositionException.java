package com.dji.mapkit.core.exceptions;

public class InvalidMarkerPositionException extends RuntimeException {
    public InvalidMarkerPositionException() {
        super("Adding an invalid Marker to a Map. Missing the required position field. Provide a non null DJILatLng as position to the Marker.");
    }
}
