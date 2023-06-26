package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Circle extends Object {
    Vector3f cp;
    Float rx;
    Float ry;
//    public Vector3f cp;
//    public Float rx, ry;
    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                  Vector3f centerPoint, Float radiusX,Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.cp = centerPoint;
        this.rx= radiusX;
        this.ry = radiusY;
//        this.cp = cp;
//        this.rx = rx;
//        this.ry = ry;

//        setupVAOVBO();
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList){
        super(shaderModuleDataList);
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
    }

    public double degToRad(float degree){
        return (degree * Math.PI / (float) 180);
    }
    public void createCircle(){
        vertices.clear();
        for(float i = 0;i<360;i+=0.1){
            double rad = degToRad(i);
            Float x = (float) (cp.get(0)+Math.cos(rad)* rx);
            Float y = (float) (cp.get(1)+Math.sin(rad)* ry);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
        }
    }
    public void createRectangle(){
        vertices.clear();
        int degree = 45;
        for(float i = 0;i<4;i++){
            double rad = degToRad(degree);
            Float x = (float) (cp.get(0)+Math.cos(rad)* rx);
            Float y = (float) (cp.get(1)+Math.sin(rad)* ry);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            degree+=90;
        }
    }
    public void createTriangle(){
        vertices.clear();
        int degree = 90;
        for(float i = 0;i<3;i++){
            double rad = degToRad(degree);
            Float x = (float) (cp.get(0)+Math.cos(rad)* rx);
            Float y = (float) (cp.get(1)+Math.sin(rad)* ry);
            Float z = 0.0f;
            vertices.add(new Vector3f(x,y,z));
            if(degree == 90){
                degree += 135;
            }
            else{
                degree += 90;
            }
        }
    }
//    public void draw(){
//        drawSetup();
//        glDrawArrays(GL_LINE_LOOP, 0, vertices.size());
//    }
}