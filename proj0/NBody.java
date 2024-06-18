public class NBody {
  public static void main(String[] args) {
    String first_arg = args[0];
    String second_arg = args[1];
    double T = Double.parseDouble(first_arg);
    double dt = Double.parseDouble(second_arg);
    String filename = args[2];
    Planet[] planets = readPlanets(filename);
    double radius = readRadius(filename);

    StdDraw.setScale(-radius, radius);
    StdDraw.clear();

    StdDraw.picture(0, 0, "images/starfield.jpg");

    // StdDraw.pause(2000);

    for (int j = 0; j < planets.length; j++) {
      planets[j].draw();
    }
    StdDraw.enableDoubleBuffering();
    StdDraw.show();
    for (double t = 0; t <= T; t += dt) {
      double[] xForce = new double[planets.length];
      double[] yForce = new double[planets.length];
      for (int i = 0; i < planets.length; i++) {
        xForce[i] = planets[i].calcNetForceExertedByX(planets);
        yForce[i] = planets[i].calcNetForceExertedByY(planets);
        planets[i].update(dt, xForce[i], yForce[i]);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        StdDraw.picture(0, 0, "images/starfield.jpg");

        StdDraw.pause(2);

        for (int k = 0; k < planets.length; k++) {
          planets[k].draw();
        }
      StdDraw.enableDoubleBuffering();
      StdDraw.show();

      }
    }
    
    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planets.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
  }

  public static double readRadius(String filename) {
    In in = new In(filename);
    int firstItemInFile = in.readInt();
    double secondItemInFile = in.readDouble();
    return secondItemInFile;
  }

  public static Planet[] readPlanets(String filename) {
    In in = new In(filename);
    int N = in.readInt();
    double radius = in.readDouble();
    Planet[] planets = new Planet[N];
    double xposition;
    double yposition;
    double xvelosity;
    double yvelosity;
    double mass;
    String planetname;
    Planet planet_element;
    for (int i = 0; i < planets.length; i++) {
      xposition = in.readDouble();
      yposition = in.readDouble();
      xvelosity = in.readDouble();
      yvelosity = in.readDouble();
      mass = in.readDouble();
      planetname = in.readString();
      planet_element = new Planet(xposition, yposition, xvelosity, yvelosity, mass, planetname);
      planets[i] = planet_element;
    }
    return planets;
  }
}