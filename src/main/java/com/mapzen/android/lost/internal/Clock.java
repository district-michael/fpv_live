package com.mapzen.android.lost.internal;

import android.location.Location;

public interface Clock {
    public static final long MS_TO_NS = 1000000;

    long getElapsedTimeInNanos(Location location);

    long getSystemElapsedTimeInNanos();
}
