import java.util.List;
import java.util.ArrayList;

public class Scene {
    private final List<Shape> shapes;

    public Scene() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public HitInfo hit(Ray ray) {
        HitInfo closestHit = null;
        for (Shape shape : shapes) {
            HitInfo hitInfo = shape.hit(ray);
            if (hitInfo != null) {
                if (closestHit == null || hitInfo.t() < closestHit.t()) {
                    closestHit = hitInfo;
                }
            }
        }
        return closestHit;
    }
}