# Christoffers primitiva Ray Tracer

En enkel Ray Tracer som skickar ut strålar från en fast kamera och räknar ut om strålarna träffar olika Shapes i scenen. Resultatet renderas sedan till en PNG-bild.

## Klasser

### Main
Startar programmet. Här skapas Scene, de Shapes som ska finnas med och Renderer som sedan renderar bilden.

### Vector3
Representerar en punkt eller riktning i 3D med x-, y- och z-värden.
Innehåller även den matematik som används av de olika geometriska formerna.

### Ray
Representerar en stråle med en startpunkt `origin` och en riktning
`direction`.

### Shape
Interface som alla Shapes måste implementera. Definierar metoden `hit`
som används för att kontrollera om en Ray träffar formen.

### Sphere
Representerar en sfär med position, radie och färg.
Implementerar `Shape` och innehåller uträkningen för om en Ray träffar sfären.

### Triangle
Representerar en triangel med tre punkter och en färg.
Implementerar `Shape` och innehåller uträkningen för om en Ray träffar triangeln.

### HitInfo
Lagrar information om en träff. Innehåller träffens t-värde och färg.

### Scene
Innehåller en lista med alla Shapes i scenen. Kontrollerar vilka Shapes en Ray träffar och returnerar träffen med lägst t-värde.

### Color
Representerar en färg med RGB-värden.

### Renderer
Går igenom bildens pixlar och skickar en Ray för varje pixel.
Använder Scene för att avgöra vilken färg pixeln ska få och skriver sedan resultatet till en PNG-fil.

## Lägg till en ny Shape

Skapa en ny klass i `geometry`-paketet.
Klassen måste implementera interfacet `Shape` och innehålla de värden som behövs för att beskriva figurens form, position och färg.
Klassen måste innehålla metoden `hit` som tar emot en `Ray` och returnerar ett `HitInfo` med ett `double t` och en `Color` om strålen träffar figuren. Om strålen inte träffar returneras `null`.
I `hit` räknar man ut om en specifik Ray träffar figuren och vilket t-värde träffen i så fall har.
Sen skapar man ett nytt objekt av klassen i `Main.java` och lägger till det i Scene med `scene.addShape(dittObjekt)`.
Eftersom Scene arbetar med interfacet `Shape` behöver man inte ändra något i `Scene` eller `Renderer` när man lägger till en ny Shape.
