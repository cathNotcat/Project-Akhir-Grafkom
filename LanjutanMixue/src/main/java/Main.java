import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window =
            new Window
                    (700,700,"Bennnn");
    ArrayList<Quadric> objects
            = new ArrayList<>();

    Camera camera = new Camera();
    float test = 0.0f;
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    ArrayList<Object> eskrim = new ArrayList<>();
    ArrayList<Object> mixue = new ArrayList<>();

    ArrayList<Circle> kursi = new ArrayList<>();

    ArrayList<Circle> papan = new ArrayList<>();
    ArrayList<Circle> pohon = new ArrayList<>();
    ArrayList<Circle> toko = new ArrayList<>();
    ArrayList<Circle> tempat = new ArrayList<>();
    ArrayList<Circle> awan = new ArrayList<>();
    ArrayList<Object> kurva = new ArrayList<>();
    ArrayList<Object> bg = new ArrayList<>();
    ArrayList<Object> lampu = new ArrayList<>();

    ArrayList<Circle> person = new ArrayList<>();

    public void init(){
        window.init();
        GL.createCapabilities();

        camera.setPosition(2.6f, 1f, -1f);

        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(180f));

        

        // mixue 1

        mixue.add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0f, 0.9f, 0.9f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"));

        mixue.get(0).scaleObject(0.2f,0.2f,0.2f);
        mixue.get(0).translateObject(2f,-0.4f,1f);

        mixue.get(0).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 0.9f, 0.9f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"));
        mixue.get(0).getChildObject().get(0).scaleObject(0.3f,0.3f,0.3f);
        mixue.get(0).getChildObject().get(0).translateObject(2f,0.22f,1f);

        mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.8f, 0f, 0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"));

      mixue.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.1f, 2.1f, 2.5f);
      mixue.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(1.55f, 1f, 1f);
      mixue.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-25f), 0.0f, 0.0f, 1f);

        ///        kepala
      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.5f, 0.5f, 0),
                              new Vector3f(-0.5f, -0.5f, 0),
                              new Vector3f(0.5f, -0.5f, 0),
                              new Vector3f(0.5f, 0.5f, 0.f)
                      )
              ),
              new Vector4f(1f, 1f, 1f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "s"
      ));
      mixue.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.2f, 0.2f, 0.2f);
      mixue.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(2f, 0.4f, 1f);

        //tangan kanan
      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.5f, 0.5f, 0),
                              new Vector3f(-0.5f, -0.5f, 0),
                              new Vector3f(0.5f, -0.5f, 0),
                              new Vector3f(0.5f, 0.5f, 0.f)
                      )
              ),
              new Vector4f(1f, 1f, 1f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "s"
      ));
      mixue.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.1f, 0.2f, 0.1f);
      mixue.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-25f), 1f, 0f, 0f);
      mixue.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(2f, 0.22f, 1.15f);

        ///        tangan kiri
      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.5f, 0.5f, 0),
                              new Vector3f(-0.5f, -0.5f, 0),
                              new Vector3f(0.5f, -0.5f, 0),
                              new Vector3f(0.5f, 0.5f, 0.f)
                      )
              ),
              new Vector4f(1f, 1f, 1f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "s"
      ));
        mixue.get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(0.1f, 0.2f, 0.1f);
        mixue.get(0).getChildObject().get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(25f), 1f, 0f, 0f);
        mixue.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(2f, 0.22f, 0.85f);


        //      //mata
      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.5f, 0.5f, 0),
                              new Vector3f(-0.5f, -0.5f, 0),
                              new Vector3f(0.5f, -0.5f, 0),
                              new Vector3f(0.5f, 0.5f, 0.f)
                      )
              ),
              new Vector4f(0.0f, 0.0f, 1.0f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "s"
      ));
      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.03f, 0.04f, 0.03f);
      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(2.08f, 0.439f, 1.02f);

        //      //mata
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"
        ));
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).scaleObject(0.03f, 0.04f, 0.03f);
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(1).translateObject(2.08f, 0.439f, 0.98f);

        //hidung
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1f, 0.5f, 0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "c"
        ));
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).scaleObject(0.03f, 0.03f, 0.1f);
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(2).translateObject(2.15f, 0.4f, 1f);

        // mulut
        mixue.get(0).getChildObject().add(new Curve(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.2f, 0.2f, 0),
                                new Vector3f(0f, 0f, 0),
                                new Vector3f(0.2f, 0.2f, 0.f)
                        )
                ),
                new Vector4f(0.8f, 0.0f, 0.0f, 1f)

        ));
        //mixue.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-12f),.0f, 1.0f, 0.0f);
        mixue.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90f),0.0f, 1.0f, 0.0f);
        mixue.get(0).getChildObject().get(1).scaleObject(0.4f, 0.01f, 0.1f);
        mixue.get(0).getChildObject().get(1).translateObject(2.09f, 0.36f, 1f);

        // mixue 2

        mixue.add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0f, 0.9f, 0.9f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"));

        mixue.get(1).scaleObject(0.2f,0.2f,0.2f);
        mixue.get(1).translateObject(2.5f,-0.4f,1f);

        mixue.get(1).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 0.9f, 0.9f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"));
        mixue.get(1).getChildObject().get(0).scaleObject(0.3f,0.3f,0.3f);
        mixue.get(1).getChildObject().get(0).translateObject(2.5f,0.22f,1f);

        mixue.get(1).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).scaleObject(0.2f, 0.2f, 0.2f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).translateObject(2.5f, 0.4f, 1f);

        //tangan kanan
        mixue.get(1).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(1).scaleObject(0.1f, 0.2f, 0.1f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(-25f), 1f, 0f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(1).translateObject(2.5f, 0.22f, 1.15f);

        ///        tangan kiri
        mixue.get(1).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(2).scaleObject(0.1f, 0.2f, 0.1f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(25f), 1f, 0f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(2).translateObject(2.5f, 0.22f, 0.85f);

        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.03f, 0.04f, 0.03f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(2.42f, 0.439f, 1.02f);

        //      //mata
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(0.0f, 0.0f, 1.0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "s"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.03f, 0.04f, 0.03f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(2.42f, 0.439f, 0.98f);

        //hidung
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1f, 0.5f, 0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "c"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.03f, 0.03f, 0.1f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(2).translateObject(2.35f, 0.4f, 1f);

        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "p"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(0.1f, 0.5f, 0.5f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(-135f), 0f, 0f, 1f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(90f), 0.0f, 1f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(3).translateObject(2.45f, 0.49f, 1.05f);

        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0f, 0.0f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "p"
        ));
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(0.1f, 0.5f, 0.5f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-135f), 0f, 0f, 1f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-90f), 0.0f, 1f, 0f);
        mixue.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(4).translateObject(2.45f, 0.49f, 0.95f);



        // orang



        // Pohon

        pohon.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(0.478f, 0.286f, 0.204f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 1.0f, 0.1f, "t"
        ));
        pohon.get(0).scaleObject(0.2f, 0.2f, 1.0f);
        pohon.get(0).rotateObject((float) Math.toRadians(90f), 1.0f, 0.0f, 0.0f);
        pohon.get(0).translateObject(3.5f, 0.5f, 2f);

        pohon.get(0).getChildObject().add(
                new Quadric(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.5f, 0.5f, 0),
                                        new Vector3f(-0.5f, -0.5f, 0),
                                        new Vector3f(0.5f, -0.5f, 0),
                                        new Vector3f(0.5f, 0.5f, 0.f)
                                )
                        ),
                        new Vector4f(0.478f, 0.286f, 0.204f, 1f),
                        new Vector3f(0.0f, 0.0f, 0.0f),
                        0.1f, 1.0f, 0.1f, "t"
                )
        );

        pohon.get(0).getChildObject().get(0).scaleObject(0.1f, 0.1f, 0.3f);
        //pohon.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1.0f, 0.0f, 0.0f);
        pohon.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(45f), 0.0f, 1.0f, 0.0f);
        pohon.get(0).getChildObject().get(0).translateObject(3.3f, 0.9f, 1.9f);

        // kursi
        kursi.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f,0.f)
                        )
                ),
                new Vector4f(0.439f, 0.173f, 0.173f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        kursi.get(0).scaleObject(12.0f, 0.5f, 2.0f);
        kursi.get(0).translateObject(2.5f, 0.15f, 2.0f);

        kursi.get(0).getChildObject().add(new Quadric(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.0f, 0.0f, 0),
                                        new Vector3f(-0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, 0.0f, 0.f)
                                )
                        ),
                        new Vector4f(0.439f, 0.173f, 0.173f, 1f),
                        new Vector3f(0.0f, 0.0f, 0.0f),
                        0.1f, 0.1f, 0.1f, "b")
        );

        kursi.get(0).getChildObject().get(0).scaleObject(2.0f, 1.0f, 2.0f);
        kursi.get(0).getChildObject().get(0).translateObject(3f, 0.1f, 2.0f);


        kursi.get(0).getChildObject().add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.439f, 0.173f, 0.173f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b")
        );

        kursi.get(0).getChildObject().get(1).scaleObject(2.0f, 1.0f, 2.0f);
        kursi.get(0).getChildObject().get(1).translateObject(2f, 0.1f, 2.0f);



        // End kursi




        //alas
        tempat.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.31f, 0.6f, 0.381f, 1f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));

       tempat.get(0).scaleObject(80.0f, 0.5f, 40.0f);
       tempat.get(0).translateObject(0.0f, 0.0f, 0.5f);

       //jalan
      tempat.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.129f, 0.133f, 0.141f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(1).scaleObject(80.0f, 0.2f, 10.0f);
      tempat.get(1).translateObject(0.0f, 0.05f, 1.0f);

      //
      tempat.add(new Quadric2(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.234f, 0.404f, 0.961f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(2).scaleObject(80.0f, 0.5f, 40.0f);
      tempat.get(2).translateObject(0.0f, 3f, 0.5f);

      tempat.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.234f, 0.404f, 0.961f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(3).scaleObject(0.5f, 30f, 40.0f);
      tempat.get(3).translateObject(4f, 1.5f, 0.5f);

      tempat.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.234f, 0.404f, 0.961f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(4).scaleObject(0.5f, 30f, 40.0f);
      tempat.get(4).translateObject(-4f, 1.5f, 0.5f);

      tempat.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.234f, 0.404f, 0.961f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(5).scaleObject(80.0f, 30.0f, 0.5f);
      tempat.get(5).translateObject(0.0f, 1.5f, 2.5f);

      tempat.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.234f, 0.404f, 0.961f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(6).scaleObject(0.5f, 30f, 40.0f);
      tempat.get(6).translateObject(1.5f, 1.5f, 0.5f);

      tempat.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(0.234f, 0.404f, 0.961f, 1f),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      tempat.get(7).scaleObject(0.5f, 30f, 40.0f);
      tempat.get(7).translateObject(-1.5f, 1.5f, 0.5f);

       tempat.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.234f, 0.404f, 0.961f, 1f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));

       tempat.get(8).scaleObject(80.0f, 30.0f, 0.5f);
       tempat.get(8).translateObject(0.0f, 1.5f, -1.5f);




        // kotak merah bawah
        toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.8f, 0.0f, 0.0f, 1f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));

        toko.get(0).scaleObject(12.0f, 1.0f, 7.0f);
        toko.get(0).translateObject(0.0f, 0.1f, 2.0f);

        // kotak putih
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.9f, 0.9f, 0.9f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(1).scaleObject(10.0f, 5.0f, 5.0f);
        toko.get(1).translateObject(0.0f, 0.4f, 2.0f);

        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.8f, 0.0f, 0.0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(2).scaleObject(12.0f, 3.0f, 7.0f);
        toko.get(2).translateObject(0.0f, 0.8f, 2.0f);

        // M kiri |
      toko.add(new Quadric(
              Arrays.asList(
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
              ),
              new ArrayList<>(
                      List.of(
                              new Vector3f(-0.0f, 0.0f, 0),
                              new Vector3f(-0.0f, -0.0f, 0),
                              new Vector3f(0.0f, -0.0f, 0),
                              new Vector3f(0.0f, 0.0f, 0.f)
                      )
              ),
              new Vector4f(1f, 1f, 1f, 1),
              new Vector3f(0.0f, 0.0f, 0.0f),
              0.1f, 0.1f, 0.1f, "b"
      ));

      toko.get(3).scaleObject(0.3f, 1.7f, 0.3f);
      toko.get(3).translateObject(0.37f, 0.8f, 1.63f);

        toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));


       toko.get(4).scaleObject(0.3f, 1.7f, 0.3f);
       toko.get(4).translateObject(-0.05f, 0.865f, 1.63f);

       toko.get(4).rotateObject((float) Math.toRadians(-25f), 0.0f, 0.0f, 1f);

        //       // M \ kiri
       toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));


        toko.get(5).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(5).translateObject(0.58f, 0.62f, 1.63f);

        toko.get(5).rotateObject((float) Math.toRadians(25f), 0.0f, 0.0f, 1f);

        // M kiri |
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(6).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(6).translateObject(0.21f, 0.8f, 1.63f);

        // I
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(7).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(7).translateObject(0.14f, 0.8f, 1.63f);

        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(8).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(8).translateObject(-0.55f, 0.55f, 1.63f);
        toko.get(8).rotateObject((float) Math.toRadians(-45f), 0.0f, 0.0f, 1f);

        // cape
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(9).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(9).translateObject(0.55f, 0.55f, 1.63f);
        toko.get(9).rotateObject((float) Math.toRadians(45f), 0.0f, 0.0f, 1f);

        //       // U | kiri
       toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));

        toko.get(10).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(10).translateObject(-0.15f, 0.8f, 1.63f);

        //       // U _ tengah
       toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));

        toko.get(11).scaleObject(1f, 0.3f, 0.3f);
        toko.get(11).translateObject(-0.2f, 0.73f, 1.63f);

        //       // U | kiri
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(12).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(12).translateObject(-0.24f, 0.8f, 1.63f);

        //   | E
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(13).scaleObject(0.3f, 1.7f, 0.3f);
        toko.get(13).translateObject(-0.31f, 0.8f, 1.63f);

        //   E bawah
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(14).scaleObject(0.9f, 0.23f, 0.3f);
        toko.get(14).translateObject(-0.34f, 0.725f, 1.63f);

        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(15).scaleObject(0.9f, 0.23f, 0.3f);
        toko.get(15).translateObject(-0.34f, 0.8f, 1.63f);

        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(1f, 1f, 1f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(16).scaleObject(0.9f, 0.23f, 0.3f);
        toko.get(16).translateObject(-0.34f, 0.875f, 1.63f);

        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0f, 0f, 0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "b"
        ));

        toko.get(17).scaleObject(2.0f, 3.5f, 0.5f);
        toko.get(17).translateObject(0.0f, 0.3f, 1.725f);


       // Terop
       toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0f, 0.0f, 0.0f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "b"
       ));


       toko.get(18).scaleObject(12.0f, 0.1f, 1.5f);
       toko.get(18).translateObject(0f, 0.65f, 1.57f);

       // Palang Kanan
       toko.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0f, 0.0f, 0.0f, 1f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 1.0f, 0.1f, "t"
       ));
       toko.get(19).scaleObject(0.02f, 0.01f, 0.455f);
       toko.get(19).rotateObject((float) Math.toRadians(90f), 1.0f, 0.0f, 0.0f);
       toko.get(19).translateObject(0.5f, 0.3f, 1.5f);

        // Palang Kanan
        toko.add(new Quadric(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.5f, 0.5f, 0),
                                new Vector3f(-0.5f, -0.5f, 0),
                                new Vector3f(0.5f, -0.5f, 0),
                                new Vector3f(0.5f, 0.5f, 0.f)
                        )
                ),
                new Vector4f(0f, 0.0f, 0.0f, 1f),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 1.0f, 0.1f, "t"
        ));
        toko.get(20).scaleObject(0.02f, 0.01f, 0.455f);
        toko.get(20).rotateObject((float) Math.toRadians(90f), 1.0f, 0.0f, 0.0f);
        toko.get(20).translateObject(-0.5f, 0.3f, 1.5f);


        // AWAN
       // elipseoid
       awan.add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(0).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(0).translateObject(-0.7f, 1.2f, 1f);
       awan.get(0).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);


       awan.get(0).getChildObject().add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(0).getChildObject().get(0).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(0).getChildObject().get(0).translateObject(-0.6f, 1.25f, 1f);
       awan.get(0).getChildObject().get(0).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

       awan.get(0).getChildObject().add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(0).getChildObject().get(1).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(0).getChildObject().get(1).translateObject(-0.6f, 1.2f, 1f);

       awan.get(0).getChildObject().add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(0).getChildObject().get(2).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(0).getChildObject().get(2).translateObject(-0.5f, 1.2f, 1f);


       // Awan 2
       awan.add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(1).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(1).translateObject(0.7f, 1.2f, 1.0f);
       awan.get(1).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);


       awan.get(1).getChildObject().add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(1).getChildObject().get(0).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(1).getChildObject().get(0).translateObject(0.6f, 1.25f, 1f);
       awan.get(1).getChildObject().get(0).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

       awan.get(1).getChildObject().add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(1).getChildObject().get(1).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(1).getChildObject().get(1).translateObject(0.6f, 1.2f, 1f);

       awan.get(1).getChildObject().add(new Quadric(Arrays.asList(
               new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
               new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
       ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.0f, 0.0f, 0),
                               new Vector3f(-0.0f, -0.0f, 0),
                               new Vector3f(0.0f, -0.0f, 0),
                               new Vector3f(0.0f, 0.0f, 0.f)
                       )
               ),
               new Vector4f(0.58f, 0.663f, 0.788f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"));
       awan.get(1).getChildObject().get(2).scaleObject(0.9f, 0.9f, 1.2f);
       awan.get(1).getChildObject().get(2).translateObject(0.5f, 1.2f, 1f);


        awan.add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));
        awan.get(2).scaleObject(1.0f, 1.0f, 1.2f);
        awan.get(2).translateObject(3.15f, 0.9f, 1.8f);
        awan.get(2).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(2).getChildObject().add(
                new Quadric(Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.0f, 0.0f, 0),
                                        new Vector3f(-0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, 0.0f, 0.f)
                                )
                        ),
                        new Vector4f(0.553f, 0.71f, 0.329f, 1),
                        new Vector3f(0.0f, 0.0f, 0.0f),
                        0.1f, 0.1f, 0.1f, "e")
        );

        awan.get(2).getChildObject().get(0).scaleObject(1.0f, 1.0f, 1.2f);
        awan.get(2).getChildObject().get(0).translateObject(3.05f, 0.76f, 1.8f);
        awan.get(2).getChildObject().get(0).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(2).getChildObject().add(
                new Quadric(Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.0f, 0.0f, 0),
                                        new Vector3f(-0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, 0.0f, 0.f)
                                )
                        ),
                        new Vector4f(0.553f, 0.71f, 0.329f, 1),
                        new Vector3f(0.0f, 0.0f, 0.0f),
                        0.1f, 0.1f, 0.1f, "e")
        );

        awan.get(2).getChildObject().get(1).scaleObject(1.0f, 1.0f, 1.2f);
        awan.get(2).getChildObject().get(1).translateObject(3.05f, 0.9f, 1.8f);
        awan.get(2).getChildObject().get(1).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(2).getChildObject().add(
                new Quadric(Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.0f, 0.0f, 0),
                                        new Vector3f(-0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, 0.0f, 0.f)
                                )
                        ),
                        new Vector4f(0.553f, 0.71f, 0.329f, 1),
                        new Vector3f(0.0f, 0.0f, 0.0f),
                        0.1f, 0.1f, 0.1f, "e")
        );

        awan.get(2).getChildObject().get(2).scaleObject(1.0f, 1.0f, 1.2f);
        awan.get(2).getChildObject().get(2).translateObject(3.1f, 1f, 1.8f);
        awan.get(2).getChildObject().get(2).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(2).getChildObject().add(
                new Quadric(Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
                ),
                        new ArrayList<>(
                                List.of(
                                        new Vector3f(-0.0f, 0.0f, 0),
                                        new Vector3f(-0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, -0.0f, 0),
                                        new Vector3f(0.0f, 0.0f, 0.f)
                                )
                        ),
                        new Vector4f(0.553f, 0.71f, 0.329f, 1),
                        new Vector3f(0.0f, 0.0f, 0.0f),
                        0.1f, 0.1f, 0.1f, "e")
        );

        awan.get(2).getChildObject().get(3).scaleObject(1.0f, 1.0f, 1.2f);
        awan.get(2).getChildObject().get(3).translateObject(3f, 0.9f, 1.8f);
        awan.get(2).getChildObject().get(3).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));


        awan.get(3).scaleObject(1.5f, 1.5f, 1.2f);
        awan.get(3).translateObject(3.5f, 1.3f, 2f);
        awan.get(3).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(3).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));


        awan.get(3).getChildObject().get(0).scaleObject(1.5f, 1.5f, 1.2f);
        awan.get(3).getChildObject().get(0).translateObject(3.7f, 1.2f, 2f);
        awan.get(3).getChildObject().get(0).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(3).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));


        awan.get(3).getChildObject().get(1).scaleObject(1.5f, 1.5f, 1.2f);
        awan.get(3).getChildObject().get(1).translateObject(3.3f, 1.2f, 2f);
        awan.get(3).getChildObject().get(1).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(3).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));


        awan.get(3).getChildObject().get(2).scaleObject(1.5f, 1.5f, 1.2f);
        awan.get(3).getChildObject().get(2).translateObject(3.6f, 1.4f, 2f);
        awan.get(3).getChildObject().get(2).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(3).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));


        awan.get(3).getChildObject().get(3).scaleObject(1.5f, 1.5f, 1.2f);
        awan.get(3).getChildObject().get(3).translateObject(3.4f, 1.4f, 2f);
        awan.get(3).getChildObject().get(3).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);

        awan.get(3).getChildObject().add(new Quadric(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(-0.0f, 0.0f, 0),
                                new Vector3f(-0.0f, -0.0f, 0),
                                new Vector3f(0.0f, -0.0f, 0),
                                new Vector3f(0.0f, 0.0f, 0.f)
                        )
                ),
                new Vector4f(0.553f, 0.71f, 0.329f, 1),
                new Vector3f(0.0f, 0.0f, 0.0f),
                0.1f, 0.1f, 0.1f, "e"));


        awan.get(3).getChildObject().get(4).scaleObject(1.5f, 1.5f, 1.2f);
        awan.get(3).getChildObject().get(4).translateObject(3.5f, 1.3f, 1.9f);
        awan.get(3).getChildObject().get(4).rotateObject(0.0f, 0.0f, 0.0f, 0.0f);


//       // START ES KRIM
       //gelas
       eskrim.add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1f, 0.0f, 0.0f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f,
               "foc"
       ));
       eskrim.get(0).scaleObject(0.19f, 0.2f, 0.2f); // 0.5, 0.5, 0.8
       eskrim.get(0).rotateObject(90f,0.0f, 1f, 0.0f);
       eskrim.get(0).rotateObject((float) Math.toRadians(270f),0.0f, 0.0f, 1.0f); // 4.7f
       eskrim.get(0).rotateObject((float) Math.toRadians(333f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).translateObject(0.6f, 0.5f, 0.0f); //0.0, -0.5, 0.0

       // es bawah
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f,
               "s"
       ));
       eskrim.get(0).getChildObject().get(0).scaleObject(0.29f, 0.1f, 0.3f);
       eskrim.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(10f),0.0f, 0.0f, 1.0f);
       eskrim.get(0).getChildObject().get(0).translateObject(0.6f, 0.5f, 0.0f);

       // es tengah
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f,
               "s"
       ));
       eskrim.get(0).getChildObject().get(1).scaleObject(0.27f, 0.1f, 0.25f); // 0.65 0.2 0.65
       eskrim.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(10f),0.0f, 0.0f, 1.0f);
       eskrim.get(0).getChildObject().get(1).translateObject(0.6f, 0.56f, 0.0f); // 0.0 0.3 0.0

       // es atas
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f,
               "s"
       ));
       eskrim.get(0).getChildObject().get(2).scaleObject(0.22f, 0.1f, 0.2f); // 0.5 0.18 0.5
       eskrim.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(10f),0.0f, 0.0f, 1.0f);
       eskrim.get(0).getChildObject().get(2).translateObject(0.6f, 0.58f, 0.0f); // 0.0 0.44 0.0

       // es atas bentuk cone
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1f, 1f, 1f, 1),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f,
               "c"
       ));

       eskrim.get(0).getChildObject().get(3).scaleObject(0.1f, 0.1f, 0.1f); // 0.2 0.2 0.2
       eskrim.get(0).getChildObject().get(3).rotateObject(90f,0.0f, 1f, 0.0f);
       eskrim.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(270f),0.0f, 0.0f, 1.0f); // 4.7f
       eskrim.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(153f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(3).translateObject(0.6f, 0.69f, 0.0f); // 0.0 0.65 0.0


       eskrim.get(0).getChildObject().add(new Circle(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f
       ));
       eskrim.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(4).translateObject(0.6f, 0.5f, 2f);
       eskrim.get(0).getChildObject().get(4).scaleObject(0.5f,0.5f,0.5f);

       // mulut
       eskrim.get(0).getChildObject().add(new Curve(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.2f, 0.2f, 0),
                               new Vector3f(0f, 0f, 0),
                               new Vector3f(0.2f, 0.2f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 0.0f, 1f)

       ));
       eskrim.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(5).scaleObject(0.23f, 0.25f, 0.0f);
       eskrim.get(0).getChildObject().get(5).translateObject(0.6f, -0.58f, -0.115f);

       // mata
       eskrim.get(0).getChildObject().add(new Circle(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f
       ));
       eskrim.get(0).getChildObject().get(6).scaleObject(0.17f, 0.26f, 0.2f);
       eskrim.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(6).translateObject(0.56f, -0.47f, -0.125f);

       // mata putih kiri
       eskrim.get(0).getChildObject().get(6).getChildObject().add(new Circle(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f
       ));
       eskrim.get(0).getChildObject().get(6).getChildObject().get(0).scaleObject(0.17f, 0.26f, 0.2f);
       eskrim.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(0.585f, -0.47f, -0.125f);

       eskrim.get(0).getChildObject().add(new Circle(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 1.0f, 1.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f
       ));
       eskrim.get(0).getChildObject().get(7).scaleObject(0.17f, 0.26f, 0.2f);
       eskrim.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(7).translateObject(0.64f, -0.47f, -0.125f);

       // mata putih kanan
       eskrim.get(0).getChildObject().get(7).getChildObject().add(new Circle(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1.0f, 1.0f, 1.0f, 1.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f
       ));
       eskrim.get(0).getChildObject().get(7).getChildObject().get(0).scaleObject(0.17f, 0.26f, 0.2f);
       eskrim.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(7).getChildObject().get(0).translateObject(0.665f, -0.47f, -0.125f);

       // hidung
       eskrim.get(0).getChildObject().add(new Circle(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(1.0f, 0.5f, 0.0f, 1.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f
       ));
       eskrim.get(0).getChildObject().get(8).scaleObject(0.17f, 0.17f, 0.2f);
       eskrim.get(0).getChildObject().get(8).rotateObject((float) Math.toRadians(-12f),1.0f, 0.0f, 0.0f);
       eskrim.get(0).getChildObject().get(8).translateObject(0.6f, -0.51f, -0.115f);

       // boba 1
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"
       ));
       eskrim.get(0).getChildObject().get(9).scaleObject(0.2f, 0.2f, 0.2f);
       eskrim.get(0).getChildObject().get(9).translateObject(0.68f, -0.26f, -0.1f);

       // boba 2
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"
       ));
       eskrim.get(0).getChildObject().get(10).scaleObject(0.2f, 0.2f, 0.2f);
       eskrim.get(0).getChildObject().get(10).translateObject(0.53f, -0.24f, -0.09f);

       // boba 3
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"
       ));
       eskrim.get(0).getChildObject().get(11).scaleObject(0.2f, 0.2f, 0.2f);
       eskrim.get(0).getChildObject().get(11).translateObject(0.53f, -0.26f, 0.1f);

       // boba 4
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"
       ));
       eskrim.get(0).getChildObject().get(12).scaleObject(0.2f, 0.2f, 0.2f);
       eskrim.get(0).getChildObject().get(12).translateObject(0.56f, -0.15f, 0.001f);

       // boba 5
       eskrim.get(0).getChildObject().add(new Quadric(
               Arrays.asList(
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
                       new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
               ),
               new ArrayList<>(
                       List.of(
                               new Vector3f(-0.5f, 0.5f, 0),
                               new Vector3f(-0.5f, -0.5f, 0),
                               new Vector3f(0.5f, -0.5f, 0),
                               new Vector3f(0.5f, 0.5f, 0.f)
                       )
               ),
               new Vector4f(0.0f, 0.0f, 0.0f, 0.0f),
               new Vector3f(0.0f, 0.0f, 0.0f),
               0.1f, 0.1f, 0.1f, "e"
       ));
       eskrim.get(0).getChildObject().get(13).scaleObject(0.2f, 0.2f, 0.2f);
       eskrim.get(0).getChildObject().get(13).translateObject(0.68f, -0.215f, 0.08f); // z semakin kecil semakin nempel

        objects.add(new Quadric(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/light.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/light.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.0f,0.0f,0.0f)
                        )
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 0.0f),
                new Vector3f(2f,0.3f,1f),
                0.5f, 0.5f, 0.5f, "b"

        ));

//        objects.get(0).scaleObject(1f,1f,1f);
//        objects.get(0).translateObject(3f,0.5f,1.5f);

        objects.add(new Quadric(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/light.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/light.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.0f,0.0f,0.0f)
                        )
                ),

                new Vector4f(0.0f, 0.0f, 1.0f, 0.0f),
                new Vector3f(0f, 0.3f, 2.0f),
                1.5f, 1f, 1.2f, "b"
        ));
    }


    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            GL.createCapabilities();
            input();

            for(Object object:bg){
                object.draw(camera, projection);
            }
            for(Object object:toko){
                object.draw(camera, projection);
            }
            for(Object object:tempat){
                object.draw(camera, projection);
            }
            for(Object object:awan){
                object.draw(camera, projection);
            }
            for(Object object: eskrim){
                object.draw(camera, projection);
            }
            for(Object object:mixue){
                object.draw(camera, projection);
            }
            for(Object object:kursi){
                object.draw(camera, projection);
            }
            for(Object object:pohon){
                object.draw(camera, projection);
            }

            for (Object object:person){
                object.draw(camera,projection);
            }

            for (Object object: papan){
                object.draw(camera,projection);
            }
            for (Object object: lampu){
                object.draw(camera,projection);
            }
//            for (Object object: objects){
//                object.draw(camera,projection);
//            }
//            objects.get(0).draw(camera,projection);
            // Restore state
            glDisableVertexAttribArray(0);

            glfwPollEvents();
        }
    }

    public void input() {
        // y tinggi, nilai positif, x kanan, nilai negatif
        float currCPX = objects.get(1).cp.x - (objects.get(0).get_rx()/2 + objects.get(1).get_rx()/2);
        float currCPY = objects.get(1).cp.y - (objects.get(0).get_ry()/2 + objects.get(1).get_ry()/2);
        float currCPZ = objects.get(1).cp.z - (objects.get(0).get_rz()/2 + objects.get(1).get_rz()/2);
        float endCPX = objects.get(1).cp.x + (objects.get(0).get_rx()/2 + objects.get(1).get_rx()/2);
        float endCPY = objects.get(1).cp.y + (objects.get(0).get_ry()/2 + objects.get(1).get_ry()/2);
        float endCPZ = objects.get(1).cp.z + (objects.get(0).get_rz()/2 + objects.get(1).get_rz()/2);

        float move = 0.01f;

        if(window.isKeyPressed(GLFW_KEY_H)){
            Vector3f temp = mixue.get(0).updateCenterPoint();
            camera.setPosition(temp.x, temp.y+0.5f, temp.z);
            camera.setRotation((float)Math.toRadians(0.0f), (float) Math.toRadians(90.0f));

        }

        if (window.isKeyPressed(GLFW_KEY_W)){
            if (objects.get(0).cp.z < currCPZ || objects.get(0).cp.z > endCPZ ||
                    objects.get(0).cp.y <= currCPY || objects.get(0).cp.y >= endCPY ||
                    objects.get(0).cp.x <= currCPX || objects.get(0).cp.x >= endCPX){
                mixue.get(0).translateObject(0.0f,0.0f,move);
                objects.get(0).translateObject(0.0f,0.0f,move);
                camera.setPosition(camera.getPosition().x,camera.getPosition().y,camera.getPosition().z+move);
            }
            else {
                objects.set(0,
                        new Quadric(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.vert"
                                                        , GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.frag"
                                                        , GL_FRAGMENT_SHADER)
                                ),
                                new ArrayList<>(
                                        List.of(
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f)
                                        )
                                ),
                                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                                new Vector3f(objects.get(0).cp.x, objects.get(0).cp.y, currCPZ),
                                0.5f, 0.5f, 0.5f, "b"
                        ));
            }

        }
        else if (window.isKeyPressed(GLFW_KEY_S)) {
            if (objects.get(0).cp.z < currCPZ || objects.get(0).cp.z > endCPZ ||
                    objects.get(0).cp.y <= currCPY || objects.get(0).cp.y >= endCPY ||
                    objects.get(0).cp.x <= currCPX || objects.get(0).cp.x >= endCPX){
                mixue.get(0).translateObject(0.0f,0.0f,-move);
                objects.get(0).translateObject(0.0f,0.0f,-move);
                camera.setPosition(camera.getPosition().x,camera.getPosition().y,camera.getPosition().z-move);
            }
            else {
                objects.set(0,
                        new Quadric(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.vert"
                                                        , GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.frag"
                                                        , GL_FRAGMENT_SHADER)
                                ),
                                new ArrayList<>(
                                        List.of(
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f)
                                        )
                                ),
                                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                                new Vector3f(objects.get(0).cp.x, objects.get(0).cp.y, endCPZ),
                                0.5f, 0.5f, 0.5f, "b"
                        ));
            }
        }
        else if (window.isKeyPressed(GLFW_KEY_A)) {
            if (objects.get(0).cp.x < currCPX || objects.get(0).cp.x >= endCPX-0.00000001f ||
                    objects.get(0).cp.y < currCPY || objects.get(0).cp.y >= endCPY ||
                    objects.get(0).cp.z <= currCPZ || objects.get(0).cp.z >= endCPZ){ // atau masalah
                mixue.get(0).translateObject(move,0.0f,0.0f);
                objects.get(0).translateObject(move,0.0f,0.0f);
                camera.setPosition(camera.getPosition().x+move,camera.getPosition().y,camera.getPosition().z);
            }
            else {
                objects.set(0,
                        new Quadric(
                                Arrays.asList(
                                        //shaderFile lokasi menyesuaikan objectnya
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.vert"
                                                        , GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.frag"
                                                        , GL_FRAGMENT_SHADER)
                                ),
                                new ArrayList<>(
                                        List.of(
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f)
                                        )
                                ),
                                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                                new Vector3f(currCPX, objects.get(0).cp.y, objects.get(0).cp.z),
                                0.5f, 0.5f, 0.5f, "b"
                        ));
            }
        }

        else if (window.isKeyPressed(GLFW_KEY_D)) {
            if (objects.get(0).cp.x <= currCPX || objects.get(0).cp.x > endCPX ||
                    objects.get(0).cp.y <= currCPY || objects.get(0).cp.y >= endCPY ||
                    objects.get(0).cp.z <= currCPZ || objects.get(0).cp.z >= endCPZ){
                mixue.get(0).translateObject(-move,0.0f,0.0f);
                objects.get(0).translateObject(-move,0.0f,0.0f);
                camera.setPosition(camera.getPosition().x-move,camera.getPosition().y,camera.getPosition().z);
            }
            else {
                objects.set(0,
                        new Quadric(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.vert"
                                                        , GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.frag"
                                                        , GL_FRAGMENT_SHADER)
                                ),
                                new ArrayList<>(
                                        List.of(
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f)
                                        )
                                ),
                                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                                new Vector3f(endCPX,objects.get(0).cp.y,objects.get(0).cp.z),
                                0.5f, 0.5f, 0.5f, "b"
                        ));
            }
        }
        else if (window.isKeyPressed(GLFW_KEY_Q)) {
            if (objects.get(0).cp.y < currCPY || objects.get(0).cp.y >= endCPY ||
                    objects.get(0).cp.x <= currCPX || objects.get(0).cp.x >= endCPX ||
                    objects.get(0).cp.z <= currCPZ || objects.get(0).cp.z >= endCPZ){
                mixue.get(0).translateObject(0.0f,move,0.0f);
                objects.get(0).translateObject(0.0f,move,0.0f);
                camera.setPosition(camera.getPosition().x,camera.getPosition().y+move,camera.getPosition().z);
            }
            else {
                objects.set(0,
                        new Quadric(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.vert"
                                                        , GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.frag"
                                                        , GL_FRAGMENT_SHADER)
                                ),
                                new ArrayList<>(
                                        List.of(
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f)
                                        )
                                ),
                                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                                new Vector3f(objects.get(0).cp.x,currCPY,objects.get(0).cp.z),
                                0.5f, 0.5f, 0.5f, "b"
                        ));
            }
        }
        else if (window.isKeyPressed(GLFW_KEY_E)) {
            if (objects.get(0).cp.y <= currCPY || objects.get(0).cp.y > endCPY ||
                    objects.get(0).cp.x <= currCPX || objects.get(0).cp.x >= endCPX ||
                    objects.get(0).cp.z <= currCPZ || objects.get(0).cp.z >= endCPZ){
                mixue.get(0).translateObject(0.0f,-move,0.0f);
                objects.get(0).translateObject(0.0f,-move,0.0f);
                camera.setPosition(camera.getPosition().x,camera.getPosition().y-move,camera.getPosition().z);
            }
            else {
                objects.set(0,
                        new Quadric(
                                Arrays.asList(
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.vert"
                                                        , GL_VERTEX_SHADER),
                                        new ShaderProgram.ShaderModuleData
                                                ("resources/shaders/light.frag"
                                                        , GL_FRAGMENT_SHADER)
                                ),
                                new ArrayList<>(
                                        List.of(
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f),
                                                new Vector3f(0.0f,0.0f,0.0f)
                                        )
                                ),
                                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                                new Vector3f(objects.get(0).cp.x,endCPY,objects.get(0).cp.z),
                                0.5f, 0.5f, 0.5f, "b"
                        ));
            }
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.moveLeft(0.025f);
            camera.addRotation(0.0f, 0.025f);
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.moveRight(0.025f);
            camera.addRotation(0.0f, -0.025f);
        }
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(0.025f);
            camera.addRotation(0.025f, 0.0f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.025f);
            camera.addRotation(-0.025f, 0.0f);
        }

        if(window.getMouseInput().isLeftButtonPressed()){
            Vector2f displayVector = window.getMouseInput().getDisplVec(); // setelah mendapat perpindahannya berapa banyak, maka di rotasi
            camera.addRotation((float) Math.toRadians(displayVector.x * 0.1), (float) Math.toRadians(displayVector.y * 0.1));
        }

        if(window.getMouseInput().getScroll().y != 0) {
            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.1f)); // dikali 0.1f supaya ga terlalu cepet
            window.getMouseInput().setScroll(new Vector2f()); //new vector2f buat jadiin 0,0
        }
        if(window.isKeyPressed(GLFW_KEY_H)){

            camera.setPosition(2.08f, 0.5f, 0.98f);
            camera.setRotation((float)Math.toRadians(0.0f), (float) Math.toRadians(-90.0f));

        }
        if(window.isKeyPressed(GLFW_KEY_I)){
            camera.addRotation((float) Math.toRadians(0.9 * 0.1), 0);
        }
        if(window.isKeyPressed(GLFW_KEY_J)){
            camera.addRotation((float) Math.toRadians(0.9 * -0.1), 0);
        }

        if(window.isKeyPressed(GLFW_KEY_P)){
            camera.addRotation(0, (float) Math.toRadians(0.9));
        }
        if(window.isKeyPressed(GLFW_KEY_O)){
            camera.addRotation(0, (float) Math.toRadians(0.9 * -1));
        }

        



    }

    public void run() {

        init();
        loop();

        // Terminate GLFW and
        // free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Main().run();
    }
}