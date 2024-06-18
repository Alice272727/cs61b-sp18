public class Planet {
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  private static final double G = 6.67e-11;

  public Planet(double xP, double yP, double xV, double yV, double m, String img) {
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
  }

  public Planet(Planet p) {
    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass = p.mass;
    this.imgFileName = p.imgFileName;
  }

  public double calcDistance(Planet p) {
    double dx = p.xxPos - this.xxPos;
    double dy = p.yyPos - this.yyPos;
    double r = Math.sqrt(dx * dx + dy * dy);
    return r;
  }

  public double calcForceExertedBy(Planet p) {
    double r = calcDistance(p);
    double force = G * p.mass * this.mass / (r * r);
    return force;
  }

  public double calcForceExertedByX(Planet p) {
    double dx = p.xxPos - this.xxPos;
    double r = calcDistance(p);
    double F = calcForceExertedBy(p);
    double Fx = F * dx / r;
    return Fx;
  }

  public double calcForceExertedByY(Planet p) {
    double dy = p.yyPos - this.yyPos;
    double r = calcDistance(p);
    double F = calcForceExertedBy(p);
    double Fy = F * dy / r;
    return Fy;
  }

  public double calcNetForceExertedByX(Planet[] planets) {
    double net_force_x = 0;
    for (int i = 0; i < planets.length; i++) {
      if (this.equals(planets[i])) {
        continue;
      } else {
        double force_x = calcForceExertedByX(planets[i]);
        net_force_x = net_force_x + force_x;
      }
    }
    return net_force_x;
  }

  public double calcNetForceExertedByY(Planet[] planets) {
    double net_force_y = 0;
    for (int i = 0; i < planets.length; i++) {
      if (equals(planets[i])) {
        continue;
      } else {
        double force_y = calcForceExertedByY(planets[i]);
        net_force_y = net_force_y + force_y;
      }
    }
    return net_force_y;
  }

  public void update(double dt, double fX, double fY) {
    double ax = fX / this.mass;
    double ay = fY / this.mass;
    this.xxVel += dt * ax;
    this.yyVel += dt * ay;
    this.xxPos += dt * this.xxVel;
    this.yyPos += dt * this.yyVel;
  }
  
  public void draw() {
    double x = this.xxPos;
    double y = this.yyPos;
    StdDraw.picture(x, y, "images/" + this.imgFileName);
  }
}
