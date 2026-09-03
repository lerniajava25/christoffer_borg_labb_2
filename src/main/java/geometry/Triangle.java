package geometry;

import math.Ray;
import math.Vector3;
import rendering.Color;

public class Triangle implements Shape {
   private final Vector3 v0;
   private final Vector3 v1;
   private final Vector3 v2;
   private final Color color;

   public Triangle(Vector3 v0, Vector3 v1, Vector3 v2, Color color) {
       this.v0 = v0;
       this.v1 = v1;
       this.v2 = v2;
       this.color = color;
   }

    @Override
    public HitInfo hit(Ray ray) {
       Vector3 edge1 = v1.subtract(v0);
       Vector3 edge2 = v2.subtract(v0);
       Vector3 h = ray.getDirection().cross(edge2);
       double a = edge1.dot(h);
       if (Math.abs(a) < 0.0000001) {
           return null;
       }
       double f = 1 / a;
       Vector3 s = ray.getOrigin().subtract(v0);
       double u = f * s.dot(h);
       if (u < 0 || u > 1) {
           return null;
       }
       Vector3 q = s.cross(edge1);
       double v = f * ray.getDirection().dot(q);
       if (v < 0 || u + v > 1) {
           return null;
       }
       double t = f * edge2.dot(q);
       if (t > 0) {
           return new HitInfo(t, color);
       }
       else {
           return null;
       }
    }
}
