package geometry;

import math.Ray;

public interface Shape {
    HitInfo hit(Ray ray);
}