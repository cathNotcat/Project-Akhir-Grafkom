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




//        ObjectLoader objectLoaded = new ObjectLoader("resources/models/stall.obj", "obj");
//        ObjectLoader objectLoaded = new ObjectLoader("resources/models/Indoor plant 3/Low-Poly Plant_.fbx", "fbx");
        //cupcake
//        camera.setPosition(0f, 1f, -5f);
        //cake
//        camera.setPosition(0.0f,0.5f,-2.0f);
        //plant
        camera.setPosition(2.6f, 1f, -1f);
//        camera.setPosition(0f, 0f, -2f);
//        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(180f));

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
//        toko.get(0).translateObject(0.0f, 0.1f, 2.0f);
//        objects.get(1).scaleObject(1f,1f,1f);
//        objects.get(1).translateObject(2.5f,0.5f,1.5f);


///        mixue snow king

//       //buat patokan rotasi ditempat
//    mixue.add(new Quadric(
//            Arrays.asList(
//                    new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                    new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                    List.of(
//                            new Vector3f(-0.5f, 0.5f, 0),
//                            new Vector3f(-0.5f, -0.5f, 0),
//                            new Vector3f(0.5f, -0.5f, 0),
//                            new Vector3f(0.5f, 0.5f, 0.f)
//                    )
//            ),
//            new Vector4f(1f, 1f, 1f, 1f),
//            new Vector3f(0.0f, 0.0f, 0.0f),
//            0.1f, 0.1f, 0.1f, "s"
//    ));
//    mixue.get(0).scaleObject(0.2f, 0.2f, 0.2f);
//    mixue.get(0).translateObject(-0.5f, -0.5f, 0.0f);

//      //badan snowking
//    mixue.get(0).getChildObject().add(new Quadric(
//            Arrays.asList(
//                    new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                    new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//            ),
//            new ArrayList<>(
//                    List.of(
//                            new Vector3f(-0.5f, 0.5f, 0),
//                            new Vector3f(-0.5f, -0.5f, 0),
//                            new Vector3f(0.5f, -0.5f, 0),
//                            new Vector3f(0.5f, 0.5f, 0.f)
//                    )
//            ),
//            new Vector4f(1f, 1f, 1f, 1f),
//            new Vector3f(0.0f, 0.0f, 0.0f),
//            0.1f, 0.1f, 0.1f, "s"
//    ));
//    mixue.get(0).getChildObject().get(0).scaleObject(0.2f, 0.2f, 0.2f);
//    mixue.get(0).getChildObject().get(0).translateObject(0f, 0.5f, 0.5f);

///       //cape
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Rectangle(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.30f, 0.4f, 0),
//                              new Vector3f(-0.55f, -0.4f, 0),
//                              new Vector3f(0.55f, -0.4f, 0),
//                              new Vector3f(0.30f, 0.4f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 0f, -1.25f, 1f),
//              Arrays.asList(0,1,2,1,2,3)

//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.5f, 0.5f, 1.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-15f), 1f, 0f, 0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.5f, -0.5f, 0.21f);


//      //kerah kiri
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Object(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.25f, 0.4f, 0),
//                              new Vector3f(-0.45f, -0.3f, 0),
//                              new Vector3f(0.7f, -0.15f, 0)

//                      )
//              ),
//              new Vector4f(1f, 0f, 0f, 1f)

//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.15f, 0.15f, 0.15f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(17f), 1f, 0f, 0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.615f, -0.36f, -0.15f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().add(new Object(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.45f, 0.4f, 0),
//                              new Vector3f(-0.55f, -0.4f, 0),
//                              new Vector3f(0.55f, -0.4f, 0),
//                              new Vector3f(0.45f, 0.4f, 0.f)

//                      )
//              ),
//              new Vector4f(1f, 0f, 0f, 1f)

//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.32f, 0.115f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0.f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).rotateObject((float) Math.toRadians(-20f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(1).getChildObject().get(0).translateObject(-0.665f, -0.35f,0.01f);

//      //kerah kanan
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Object(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.25f, 0.4f, 0),
//                              new Vector3f(-0.45f, -0.3f, 0),
//                              new Vector3f(0.7f, -0.15f, 0)

//                      )
//              ),
//              new Vector4f(1f, 0f, 0f, 1f)

//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.15f, 0.15f, 0.15f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(180f), 0f, 1f, 0.f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(17f), 1f, 0f, 0.0f);//
//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.39f, -0.36f, -0.15f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().add(new Object(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.45f, 0.4f, 0),
//                              new Vector3f(-0.55f, -0.4f, 0),
//                              new Vector3f(0.55f, -0.4f, 0),
//                              new Vector3f(0.45f, 0.4f, 0.f)

//                      )
//              ),
//              new Vector4f(1f, 0f, 0f, 1f)

//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).scaleObject(0.32f, 0.115f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0.f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float) Math.toRadians(20f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.335f, -0.35f, 0.01f);

///        kepala
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(1.5f, 1.5f, 1.5f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(-0.5f, -0.24f, 0.0f);

//     //tangan kanan
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(0.5f, 1.2f, 0.5f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(25f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(-0.30f, -0.52f, 0.0f);

///        tangan kiri
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(5).scaleObject(0.5f, 1.2f, 0.5f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-45f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(180f), 1f, 0f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(5).translateObject(-0.7f, -0.42f, 0.0f);

//      //tongkat sakti
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 0.8f, 0.0f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 1.0f, 0.1f, "t"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(6).scaleObject(0.01f, 0.01f, 0.3f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(6).translateObject(-0.79f, -0.45f, 0.0f);

//      // es krim snow king
//      //cone
//      mixue.get(0).getChildObject().get(0).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 0.8f, 0.0f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f,
//              "c"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).scaleObject(0.05f, 0.05f, 0.15f); // 0.5, 0.5, 0.8
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).rotateObject(90f,0.0f, 1f, 0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(270f),0.0f, 0.0f, 1.0f); // 4.7f
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(333f),1.0f, 0.0f, 0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).translateObject(-0.79f, -0.25f, 0.0f); //0.0, -0.5, 0.0

//      // es bawah
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f,
//              "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(0).scaleObject(0.08f, 0.03f, 0.08f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(-5f),0f, 0.0f, 1.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(0).translateObject(-0.79f, -0.135f, 0.0f);

//      // es tengah
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f,
//              "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(1).scaleObject(0.06f, 0.03f, 0.06f); // 0.65 0.2 0.65
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(-5f),0f, 0.0f, 1.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(1).translateObject(-0.79f, -0.12f, 0.0f); // 0.0 0.3 0.0

//      // es atas
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f,
//              "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(2).scaleObject(0.04f, 0.02f, 0.04f); // 0.5 0.18 0.5
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(-6f),0f, 0.0f, 1.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(2).translateObject(-0.79f, -0.105f, 0.0f); // 0.0 0.44 0.0

//      // es atas bentuk cone
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f,
//              "c"
//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(3).scaleObject(0.015f, 0.015f, 0.015f); // 0.2 0.2 0.2
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(3).rotateObject(90f,0.0f, 1f, 0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(3).rotateObject((float) Math.toRadians(270f),0.0f, 0.0f, 1.0f); // 4.7f
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(3).rotateObject((float) Math.toRadians(153f),1.0f, 0.0f, 0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(3).rotateObject((float) Math.toRadians(-7f),0f, 0.0f, 1.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(7).getChildObject().get(3).translateObject(-0.788f, -0.083f, 0.0f); // 0.0 0.65 0.0

//      //mata
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(0.0f, 0.0f, 1.0f, 1f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.3f, 0.4f, 0.3f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.55f, -0.21f, -0.115f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).scaleObject(0.15f, 0.3f, 0.3f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(1).translateObject(-0.53f, -0.21f, -0.13f);


//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(0.0f, 0.0f, 1.0f, 1f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(2).scaleObject(0.3f, 0.4f, 0.3f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(2).translateObject(-0.45f, -0.21f, -0.119f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 1f, 1f, 1),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(3).scaleObject(0.15f, 0.3f, 0.3f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(3).translateObject(-0.43f, -0.21f, -0.115f);

      //hidung
//     mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//             Arrays.asList(
//                     new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                     new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//             ),
//             new ArrayList<>(
//                     List.of(
//                             new Vector3f(-0.5f, 0.5f, 0),
//                             new Vector3f(-0.5f, -0.5f, 0),
//                             new Vector3f(0.5f, -0.5f, 0),
//                             new Vector3f(0.5f, 0.5f, 0.f)
//                     )
//             ),
//             new Vector4f(1f, 0.5f, 0f, 1f),
//             new Vector3f(0.0f, 0.0f, 0.0f),
//             0.1f, 0.1f, 0.1f, "c"
//     ));
//     mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(4).scaleObject(0.03f, 0.03f, 0.1f);
//     mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(4).rotateObject((float) Math.toRadians(180f), 1f, 0f, 0f);
//     mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(4).translateObject(-0.5f, -0.275f, -0.21f);

//      //mulut
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Curve(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.2f, 0.2f, 0),
//                              new Vector3f(0f, 0f, 0),
//                              new Vector3f(0.2f, 0.2f, 0.f)
//                      )
//              ),
//              new Vector4f(0f, 0f, 1f, 1f)

//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(5).scaleObject(0.25f, 0.25f, 0f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(5).translateObject(-0.5f, -0.36f, -0.125f);

//      //lidah
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.2f, 0.2f, 0),
//                              new Vector3f(0f, 0f, 0),
//                              new Vector3f(0.2f, 0.2f, 0.f)
//                      )
//              ),
//              new Vector4f(1f, 0f, 0f, 1f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(6).scaleObject(0.04f, 0.03f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(6).rotateObject((float) Math.toRadians(-25f), 0.0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(6).translateObject(-0.55f, -0.313f, -0.129f);

//      //mahkota
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "p"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(7).scaleObject(0.2f, 0.8f, 0.8f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(7).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(7).rotateObject((float) Math.toRadians(-45f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(7).rotateObject((float) Math.toRadians(-25f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(7).translateObject(-0.465f, -0.125f, -0.05f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "p"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(8).scaleObject(0.2f, 0.8f, 0.8f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(8).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(8).rotateObject((float) Math.toRadians(-45f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(8).rotateObject((float) Math.toRadians(25f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(8).translateObject(-0.535f, -0.125f, -0.05f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "p"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(9).scaleObject(0.2f, 1.0f, 1.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(9).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(9).rotateObject((float) Math.toRadians(-45f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(9).translateObject(-0.5f, -0.125f, 0.05f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "p"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(10).scaleObject(0.2f, 0.8f, 0.8f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(10).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(10).rotateObject((float) Math.toRadians(-45f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(10).rotateObject((float) Math.toRadians(70f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(10).translateObject(-0.44f, -0.125f, 0.01f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "p"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(11).scaleObject(0.2f, 0.8f, 0.8f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(11).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(11).rotateObject((float) Math.toRadians(-45f), 0f, 0f, 1f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(11).rotateObject((float) Math.toRadians(100f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(11).translateObject(-0.57f, -0.125f, 0.0f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(12).scaleObject(0.03f, 0.03f, 0.03f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(12).rotateObject((float) Math.toRadians(25f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(12).translateObject(-0.435f, -0.06f, -0.0f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(13).scaleObject(0.03f, 0.03f, 0.03f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(13).rotateObject((float) Math.toRadians(-25f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(13).translateObject(-0.57f, -0.06f, -0.0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(14).scaleObject(0.03f, 0.03f, 0.03f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(14).translateObject(-0.5f, -0.06f, 0.05f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(15).scaleObject(0.03f, 0.03f, 0.03f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(15).rotateObject((float) Math.toRadians(115f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(15).translateObject(-0.465f, -0.06f, -0.045f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new Quadric(
//              Arrays.asList(
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.vert", GL_VERTEX_SHADER),
//                      new ShaderProgram.ShaderModuleData("resources/shaders/light.frag", GL_FRAGMENT_SHADER)
//              ),
//              new ArrayList<>(
//                      List.of(
//                              new Vector3f(-0.5f, 0.5f, 0),
//                              new Vector3f(-0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, -0.5f, 0),
//                              new Vector3f(0.5f, 0.5f, 0.f)
//                      )
//              ),
//              new Vector4f(1.0f, 1.0f, 1f, 0.0f),
//              new Vector3f(0.0f, 0.0f, 0.0f),
//              0.1f, 0.1f, 0.1f, "s"
//      ));
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(16).scaleObject(0.03f, 0.03f, 0.03f);

//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(16).rotateObject((float) Math.toRadians(75f), 0.0f, 1f, 0f);
//      mixue.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(16).translateObject(-0.535f, -0.06f, -0.045f);

//        camera.setRotation((float)Math.toRadians(0.0f), (float) Math.toRadians(30.0f));

        //code
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/light.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/light.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,0.0f,1.0f,1.0f)
//        ));
//
//        objects.add(new Object2d(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f,0.5f,0.0f),
//                                new Vector3f(0.0f,1.0f,0.0f),
//                                new Vector3f(0.0f,0.0f,1.0f)
//                        )
//                )
//        ));
//

//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.125f,
//                0.125f,
//                0.125f
//        ));
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.940f, 0.577f, 0.103f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(0).scaleObject(0.1f,0.1f,0.1f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.780f, 0.700f, 0.343f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(1).translateObject(3.25f, 0.0f, 0.0f);
//        objects.get(1).scaleObject(0.1f,0.1f,0.1f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.570f, 0.437f, 0.00f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(2).translateObject(3.15f, 0.0f, 0.0f);
//        objects.get(2).scaleObject(0.15f,0.15f,0.15f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.160f, 0.747f, 0.800f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(3).translateObject(3.35f, 0.0f, 0.0f);
//        objects.get(3).scaleObject(0.2f,0.2f,0.2f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.510f, 0.510f, 0.510f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(4).translateObject(16.2f, 0.0f, 0.0f);
//        objects.get(4).scaleObject(0.05f,0.05f,0.05f);
//
//        objects.add(new Sphere(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.vert"
//                                , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData(
//                                "resources/shaders/light.frag"
//                                , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.430f, 0.0258f, 0.0258f,1.0f),
//                Arrays.asList(0.0f,0.0f,0.0f),
//                0.5f,
//                0.5f,
//                0.5f
//        ));
//        objects.get(5).translateObject(7f, 0.0f, 0.0f);
//        objects.get(5).scaleObject(0.13f,0.13f,0.13f);
//
//        objects.get(0).scaleObject(2.0f, 2.0f, 2.0f);
//        objects.get(0).getChildObject().add(new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/light.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/light.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(-0.5f,0.5f,0.0f),
//                                        new Vector3f(-0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,0.5f,0.0f)
//                                )
//                        ),
//                        new Vector4f(0.0f,0.0f,1.0f,1.0f),
//                        Arrays.asList(0.0f,0.0f,0.0f),
//                        0.125f,
//                        0.125f,
//                        0.125f
//                )
//        );
////        objects.get(0).getChildObject().get(0).translateObject(0.6f,0.0f,0.1f);
//
//        objects.get(0).getChildObject().add(new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/light.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/light.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(-0.5f,0.5f,0.0f),
//                                        new Vector3f(-0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,0.5f,0.0f)
//                                )
//                        ),
//                        new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                        Arrays.asList(0.0f,0.0f,0.0f),
//                        0.125f,
//                        0.125f,
//                        0.125f
//                )
//        );
//        objects.get(0).getChildObject().get(1).translateObject(0.5f,0.0f,0.0f);
//
//        objects.get(0).getChildObject().get(1).getChildObject().add(new Sphere(
//                        Arrays.asList(
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/light.vert"
//                                        , GL_VERTEX_SHADER),
//                                new ShaderProgram.ShaderModuleData(
//                                        "resources/shaders/light.frag"
//                                        , GL_FRAGMENT_SHADER)
//                        ),
//                        new ArrayList<>(
//                                List.of(
//                                        new Vector3f(-0.5f,0.5f,0.0f),
//                                        new Vector3f(-0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,-0.5f,0.0f),
//                                        new Vector3f(0.5f,0.5f,0.0f)
//                                )
//                        ),
//                        new Vector4f(0.0f,1.0f,1.0f,1.0f),
//                        Arrays.asList(0.0f,0.0f,0.0f),
//                        0.125f,
//                        0.125f,
//                        0.125f
//                )
//        );
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.0f);
//        objects.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.2f, -0.1f, 0.5f);
//
//        camera.setPosition(0,0,1f);


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
//    public void input(){
////        ArrayList<Object2d> tempCirlce = new ArrayList<>();
////        if(window.isKeyPressed(GLFW_KEY_G)) {
////            if (window.isKeyPressed(GLFW_KEY_G)){
////                objects.get(0).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
////                Vector3f temp = objects.get(1).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//////
////                objects.get(1).translateObject(-temp.x,-temp.y,0f);
////                objects.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
////                objects.get(1).translateObject(temp.x,temp.y,0f);
////                temp = objects.get(2).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//////
////                objects.get(2).translateObject(-temp.x,-temp.y,0f);
////                objects.get(2).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
////                objects.get(2).translateObject(temp.x,temp.y,0f);
////                temp = objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//////
////                objects.get(3).translateObject(-temp.x,-temp.y,0f);
////                objects.get(3).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
////                objects.get(3).translateObject(temp.x,temp.y,0f);
////                temp = objects.get(5).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//////
////                objects.get(5).translateObject(-temp.x,-temp.y,0f);
////                objects.get(5).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
////                objects.get(5).translateObject(temp.x,temp.y,0f);
//////            objects.get(1).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
//////            objects.get(2).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
//////            objects.get(3).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
//////            objects.get(5).rotateObject((float) Math.toRadians(0.5f),0f,0f,0f);
////            }
////        }
////        if(window.isKeyPressed(GLFW_KEY_F)) {
////            objects.get(1).rotateObject((float)Math.toRadians(1.7f), 0.0f, 0.0f, 1.0f);
//////            objects.get(1).rotateObject((float)Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
////            objects.get(2).rotateObject((float)Math.toRadians(1.6f), 0.0f, 0.0f, 1.0f);
////            objects.get(3).rotateObject((float)Math.toRadians(1.5f), 0.0f, 0.0f, 1.0f);
////            objects.get(4).rotateObject((float)Math.toRadians(1.5f), 0.0f, 0.0f, 1.0f);
////            objects.get(5).rotateObject((float)Math.toRadians(1.4f), 0.0f, 0.0f, 1.0f);
////        }
////        if (window.isKeyPressed(GLFW_KEY_H)){
////            Vector3f bumi = objects.get(3).model.transformPosition(new Vector3f(0.0f,0.0f,0f));
//////
////            objects.get(4).translateObject(-bumi.x,-bumi.y,0f);
////            objects.get(4).rotateObject((float) Math.toRadians(0.5f),0f,0f,1f);
////            objects.get(4).translateObject(bumi.x,bumi.y,0f);
////        }
//        float move = 0.0025f;
//        if (window.isKeyPressed(GLFW_KEY_W)){
////            objects.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,-0.01f);
//            camera.setPosition(camera.getPosition().x,camera.getPosition().y,camera.getPosition().z-0.01f);
////            camera.moveForward(move);
//
////            objects.get(0).rotateObject(((float) Math.toRadians(0.5f)), 0.0f, 0.0f, 1.0f);
////            for(Object child:objects.get(0).getChildObject()){
////                Vector3f tempCenterPoint = child.updateCenterPoint();
////                child.translateObject(tempCenterPoint.x*-1, tempCenterPoint.y*-1,
////                        tempCenterPoint.z*-1);
////                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 0.0f, 1.0f);
////                child.translateObject(tempCenterPoint.x, tempCenterPoint.y,
////                        tempCenterPoint.z);
////            }
////
////            for(Object child:objects.get(0).getChildObject().get(1).getChildObject()){
////                Vector3f tempCenterPoint = objects.get(0).getChildObject().get(1).updateCenterPoint();
////                child.translateObject(tempCenterPoint.x*-1, tempCenterPoint.y*-1,
////                        tempCenterPoint.z*-1);
////                child.rotateObject((float) Math.toRadians(0.7f), 0.0f, 0.0f, 1.0f);
////                child.translateObject(tempCenterPoint.x, tempCenterPoint.y,
////                        tempCenterPoint.z);
////            }
//        }
//        if (window.isKeyPressed(GLFW_KEY_S)) {
////            objects.get(0).getChildObject().get(0).translateObject(0.0f,0.0f,0.01f);
////            camera.moveBackwards(move);
//            camera.setPosition(camera.getPosition().x,camera.getPosition().y,camera.getPosition().z+0.01f);
//
//        }
//        if (window.isKeyPressed(GLFW_KEY_A)) {
////            objects.get(0).getChildObject().get(0).translateObject(-0.01f,0.0f,0.0f);
////            camera.moveLeft(move);
//            camera.setPosition(camera.getPosition().x-0.01f,camera.getPosition().y,camera.getPosition().z);
//
//        }
//        if (window.isKeyPressed(GLFW_KEY_D)) {
////            objects.get(0).getChildObject().get(0).translateObject(0.01f,0.0f,0.0f);
////            camera.moveRight(move);
//            camera.setPosition(camera.getPosition().x+0.01f,camera.getPosition().y,camera.getPosition().z);
//        }
//        if (window.isKeyPressed(GLFW_KEY_UP)) {
////            objects.get(0).getChildObject().get(0).translateObject(0.0f,0.01f,0.0f);
////            camera.moveUp(move);
//            camera.setPosition(camera.getPosition().x,camera.getPosition().y+0.01f,camera.getPosition().z);
//
//        }
//        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
////            objects.get(0).getChildObject().get(0).translateObject(0.0f,-0.01f,0.0f);
////            camera.moveDown(move);
//            camera.setPosition(camera.getPosition().x,camera.getPosition().y-0.01f,camera.getPosition().z);
//
//        }
//        if (window.isKeyPressed(GLFW_KEY_Z)) {
//            camera.moveUp(0.025f);
//            camera.addRotation(0.025f, 0.0f);
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_X)) {
//            camera.moveDown(0.025f);
//            camera.addRotation(-0.025f, 0.0f);
//        }
//        if (window.isKeyPressed(GLFW_KEY_C)) {
//            camera.moveLeft(0.025f);
//            camera.addRotation(0.0f, 0.025f);
//        }
//        if (window.isKeyPressed(GLFW_KEY_V)) {
//            camera.moveRight(0.025f);
//            camera.addRotation(0.0f, -0.025f);
//        }
////        if (window.isKeyPressed(GLFW_KEY_R)){
////            test = 2f;
////        }
////        if (test < 200f && test > 0f){
////            camera.addRotation(0, (float)Math.toRadians(test));
////        }
//        if (window.getMouseInput().isLeftButtonPressed()){
//            Vector2f displayVector = window.getMouseInput().getDisplVec();
//            camera.addRotation((float) Math.toRadians(displayVector.x * 0.1f), (float) Math.toRadians(displayVector.y * 0.1f));
//
////            boolean check = true;
////            Vector2f pos = window.getMouseInput().getCurrentPos();
////            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
////            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
////
////            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1) && (pos.x != 0.0 && pos.y != 0.0))) {
////                System.out.println("x : "+pos.x+" y : "+pos.y);
////            }
//        }
//        if (window.getMouseInput().getScroll().y != 0){
//            projection.setFOV(projection.getFOV() - (window.getMouseInput().getScroll().y * 0.01f));
//            window.getMouseInput().setScroll(new Vector2f());
//        }
//    }

    //    public void input(){
//        ArrayList<Object2d> tempCirlce = new ArrayList<>();
//        if (window.isKeyPressed(GLFW_KEY_W)){
//            System.out.println("W");
//        }
//        if (window.getMouseInput().isLeftButtonPressed()){
//            boolean check = true;
//            Vector2f pos = window.getMouseInput().getCurrentPos();
//            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
//            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1) && (pos.x != 0.0 && pos.y != 0.0))) {
////                System.out.println("x : "+pos.x+" y : "+pos.y);
//                if(objectsCircle.isEmpty()) {
//                    objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                    objectsCircle.add(new Circle(
//                            Arrays.asList(
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/light.vert"
//                                                    , GL_VERTEX_SHADER),
//                                    new ShaderProgram.ShaderModuleData
//                                            ("resources/shaders/light.frag"
//                                                    , GL_FRAGMENT_SHADER)
//                            ),
//                            new ArrayList<>(),
//                            new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                            pos.x, pos.y, 0.1f, 0.1f, 45.0f
//                    ));
//                    tempPos.add(new Vector2f(pos));
//                    System.out.println(objectsCircle.size());
//                    objectsCurve.get(0).addVerticesCurve(new Vector3f(pos.x, pos.y, 0));
//                } else {
//                    for (int i = 0; i < objectsCircle.size();i++) {
//                        if((Math.sqrt((Math.pow((pos.x - tempPos.get(i).x), 2) +
//                                (Math.pow((pos.y - tempPos.get(i).y), 2))))) <= 0.07f) {
//                            tempCirlce.add(objectsCircle.get(i));
//                        }
//                    }
//                    for (int i = 0; i < objectsCircle.size(); i++) {
//                        if((Math.sqrt((Math.pow((pos.x - tempPos.get(i).x), 2) +
//                                (Math.pow((pos.y - tempPos.get(i).y), 2))))) <= 0.07f) {
//                            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1) && (pos.x != 0.0 && pos.y != 0.0))
//                                    && objectsCircle.get(i) == tempCirlce.get(0)) {
//                                objectsCircle.set(i, new Circle(
//                                        Arrays.asList(
//                                                new ShaderProgram.ShaderModuleData
//                                                        ("resources/shaders/light.vert"
//                                                                , GL_VERTEX_SHADER),
//                                                new ShaderProgram.ShaderModuleData
//                                                        ("resources/shaders/light.frag"
//                                                                , GL_FRAGMENT_SHADER)
//                                        ),
//                                        new ArrayList<>(),
//                                        new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                                        pos.x, pos.y, 0.1f, 0.1f, 45.0f
//                                ));
//                                tempPos.set(i, new Vector2f(pos));
//                                objectsPointsControl.get(0).setVertices(i, new Vector3f(pos.x, pos.y, 0.0f));
//                                objectsCurve.get(0).setVerticesCurve(i, new Vector3f(pos.x, pos.y, 0.0f));
//                                check = false;
//
//                            }
//                        } else if ((Math.sqrt((Math.pow((pos.x - tempPos.get(i).x), 2) +
//                                (Math.pow((pos.y - tempPos.get(i).y), 2))))) <= 0.15f) {
//                            check = false;
//                        }
//                    }
//
////                System.out.println(objectsCurve.get(0).createBezier(objectsCurve.get(0).getVertices().size(), objectsCurve.get(0).getVertices()));
//                    if (check) {
//                        objectsPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//                        objectsCircle.add(new Circle(
//                                Arrays.asList(
//                                        new ShaderProgram.ShaderModuleData
//                                                ("resources/shaders/light.vert"
//                                                        , GL_VERTEX_SHADER),
//                                        new ShaderProgram.ShaderModuleData
//                                                ("resources/shaders/light.frag"
//                                                        , GL_FRAGMENT_SHADER)
//                                ),
//                                new ArrayList<>(),
//                                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
//                                pos.x, pos.y, 0.1f, 0.1f, 45.0f
//                        ));
//                        tempPos.add(new Vector2f(pos));
//                        objectsCurve.get(0).addVerticesCurve(new Vector3f(pos.x, pos.y, 0));
//                    }
//                }
//            }
//        }
//    }
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