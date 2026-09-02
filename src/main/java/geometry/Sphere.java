package geometry;

import math.Ray;
import math.Vector3;

public class Sphere implements Shape {
    private final Vector3 center;
    private final double radius;

    public Sphere(Vector3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public HitInfo hit(Ray ray) {
        Vector3 centerToOrigin = ray.getOrigin().subtract(center);
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2 * centerToOrigin.dot(ray.getDirection());
        double c = centerToOrigin.dot(centerToOrigin) - radius * radius;
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
            return null;
        double t1 = (-b - Math.sqrt(discriminant)) / (2 * a);
        double t2 = (-b + Math.sqrt(discriminant)) / (2 * a);
        if (t1 > 0 && t2 > 0) {
            return new HitInfo(Math.min(t1, t2));
        }
        if (t1 > 0) {
            return new HitInfo(t1);
        }
        if (t2 > 0) {
            return new HitInfo(t2);
        }
            return null;
    }
}
