# Christoffers primitiva Ray Tracer

En enkel Ray Tracer som skickar ut strålar från en fast kamera och räknar ut om strålarna träffar olika Shapes i scenen. Resultatet renderas sedan till en PNG-bild.

## Lägg till en ny Shape

Skapa en ny klass i `geometry`-paketet.

Klassen måste implementera interfacet `Shape` och innehålla de värden som behövs för att beskriva figurens form, position och färg.

Klassen måste innehålla metoden `hit` som tar emot en `Ray` och returnerar ett `HitInfo` med ett `double t` och en `Color` om strålen träffar figuren. Om strålen inte träffar returneras `null`.

I `hit` räknar man ut om en specifik Ray träffar figuren och vilket t-värde träffen i så fall har.

Sen skapar man ett nytt objekt av klassen i `Main.java` och lägger till det i Scene med `scene.addShape(dittObjekt)`.

Eftersom Scene arbetar med interfacet `Shape` behöver man inte ändra något i `Scene` eller `Renderer` när man lägger till en ny Shape.
