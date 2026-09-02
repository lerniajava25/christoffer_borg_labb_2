package app;

import geometry.Sphere;
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
        Renderer renderer = new Renderer(400, 400);
        renderer.render(scene);
    }
}
