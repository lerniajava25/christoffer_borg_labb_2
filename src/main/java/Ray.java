public class Ray {
   private final Vector3 origin;
   private final Vector3 direction;

   public Ray(Vector3 origin, Vector3 direction) {
      if (direction.dot(direction) == 0) {
         throw new IllegalArgumentException("Ray direction cannot be zero");
      }
      this.origin = origin;
      this.direction = direction;
   }
   public Vector3 getOrigin() {
      return origin;
   }

   public Vector3 getDirection() {
      return direction;
   }


}
