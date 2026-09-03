package app;

import geometry.Sphere;
import geometry.Triangle;
import math.Vector3;
import rendering.Color;
import rendering.Renderer;
import scene.Scene;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Scene scene = new Scene();
        Vector3 center = new Vector3(0,0,3);
        Sphere sphere = new Sphere(center, 1, Color.BLUE);
        scene.addShape(sphere);
        Vector3 v0 = new Vector3(-2, -1, 3);
        Vector3 v1 = new Vector3(-1, -1, 3);
        Vector3 v2 = new Vector3(-1.5, 1, 3);
        Triangle triangle = new Triangle(v0, v1, v2, Color.RED);
        scene.addShape(triangle);
        Renderer renderer = new Renderer(400, 400);
        renderer.render(scene);
    }
}
