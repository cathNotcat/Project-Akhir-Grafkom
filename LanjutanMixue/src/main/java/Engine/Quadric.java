package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sin;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;

public class Quadric extends Circle{

    Float rz, rx, ry;
    List<Integer> index;
    int ibo;
    int stackCount = 200, sectorCount = 300;
    String choice ;
    int nbo;
    List<Vector3f> normal;
    float r1 = 0.6f, r2 = 0.35f, h = 2.3f;
    public  Vector3f cp;
    float heigth, width;

    public Quadric(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, Vector3f cp, Float rx, Float ry, Float rz, String choice) {
        super(shaderModuleDataList, vertices, color, cp, rx, ry);
//        super(shaderModuleDataList, vertices, color, centerPoint, rx, ry);
        this.rz = rz;
        this.rx = rx;
        this.ry = ry;
//        drawTorus(innerRadius, outerRadius, sides, rings);
//        createBox();
//        createSphere();
//        createElipsoid();
//        createHyperboloid1();
//        createHyperboloid2();
        this.choice = choice;
        this.cp=cp;
        if (choice == "c") createCone();
        else if (choice == "s") createSphere();
        else if ( choice == "e") createElipsoid();
        else if ( choice == "h1") createHyperboloid1();
        else if ( choice == "t") createTube();
        else if ( choice == "b") createBox();
        else if ( choice == "ep") createEParaboloid();
        else if ( choice == "r") createRing();
        else if ( choice == "j") createJubah();
        else if ( choice == "p") createPrism();
        else if ( choice == "foc") createFrustumOfCone(r1, r2, h);

        setupVAOVBO();
    }

    public float distance(Quadric other) {
        float dx = cp.x - other.cp.x;
        float dy = cp.y - other.cp.y;
        float dz = cp.z - other.cp.z;

        return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public void translateObject(Float offsetX,Float offsetY,Float offsetZ){
        model = new Matrix4f().translate(offsetX,offsetY,offsetZ).mul(new Matrix4f(model));
        for (Object child: childObject){
            child.translateObject(offsetX,offsetY,offsetZ);
        }
        cp.x += offsetX;
        cp.y += offsetY;
        cp.z += offsetZ;
    }


    public boolean collidesWith(Quadric otherQuadric) {
        float distance = cp.distance(otherQuadric.getCenterPoint());
        float sumRadii = rx + otherQuadric.get_rx();
        return distance <= sumRadii;
    }

    public void setPosition(float x, float y, float z) {
        cp = new Vector3f(x, y, z);
        // Additional calculations or updates based on the new position can be done here
    }
    public Vector3f getPosition() {
        return cp;
    }


    public void set_rx(float x){
        rx = x;
    }
    public void set_ry(float y){
        ry = y;
    }
    public void set_rz(float z){
        rz = z;
    }

    public float get_rx(){
        return rx;
    }
    public float get_ry(){
        return ry;
    }
    public float get_rz(){
        return rz;
    }

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f(0f,0f,0f);
        model.transformPosition(centerTemp);
        return centerTemp;
    }

    public Vector3f getCenterPoint(){ return cp;}


    public void setHeight(float h){
        this.heigth = h;
    }
    public void setWidth(float w){
        this.width = w;
    }


    public List<Vector3f> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setIndicies(List<Integer> indicies){
        this.index = indicies;
        setupVAOVBO();
        //ibo
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }

    public void drawTorus(float innerRadius, float outerRadius, int sides, int rings) {
        float ringDelta = (float) (2.0f * Math.PI / rings);
        float sideDelta = (float) (2.0f * Math.PI / sides);
        float theta = 0.0f;

        for (int i = 0; i < rings; i++) {
            float phi = 0.0f;
            GL11.glBegin(GL11.GL_QUAD_STRIP);
            for (int j = 0; j <= sides; j++) {
                float cosTheta = (float) Math.cos(theta);
                float sinTheta = (float) sin(theta);
                float cosPhi = (float) Math.cos(phi);
                float sinPhi = (float) sin(phi);
                float x = (outerRadius + innerRadius * cosPhi) * cosTheta;
                float y = (outerRadius + innerRadius * cosPhi) * sinTheta;
                float z = innerRadius * sinPhi;
                GL11.glVertex3f(x, y, z);

                x = (float) ((outerRadius + innerRadius * cosPhi) * Math.cos((theta + sideDelta)));
                y = (float) ((outerRadius + innerRadius * cosPhi) * sin((theta + sideDelta)));
                z = innerRadius * sinPhi;
                GL11.glVertex3f(x, y, z);
                phi += sideDelta;
            }
            GL11.glEnd();
            theta += ringDelta;
        }
    }


    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) - ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) - ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) - ry / 2.0f;
        temp.z = cp.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) - ry / 2.0f;
        temp.z = cp.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
//        vertices.clear();
//        Vector3f temp = new Vector3f();
//        ArrayList<Vector3f> tempVertices = new ArrayList<>();
//        //titik 1 kiri atas belakang
//        temp.x = cp.get(0) - rx / 2;
//        temp.y = cp.get(1) + ry / 2;
//        temp.z = cp.get(2) - rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 2 kiri bawah belakang
//        temp.x = cp.get(0) - rx / 2;
//        temp.y = cp.get(1) - ry / 2;
//        temp.z = cp.get(2) - rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 3 kanan bawah belakang
//        temp.x = cp.get(0) + rx / 2;
//        temp.y = cp.get(1) - ry / 2;
//        temp.z = cp.get(2) - rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 4 kanan atas belakang
//        temp.x = cp.get(0) + rx / 2;
//        temp.y = cp.get(1) + ry / 2;
//        temp.z = cp.get(2) - rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 5 kiri bawah depam
//        temp.x = cp.get(0) - rx / 2;
//        temp.y = cp.get(1) + ry / 2;
//        temp.z = cp.get(2) + rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 6 kiri bawah depan
//        temp.x = cp.get(0) + rx / 2;
//        temp.y = cp.get(1) - ry / 2;
//        temp.z = cp.get(2) - rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 7 kanan bawah depan
//        temp.x = cp.get(0) + rx / 2;
//        temp.y = cp.get(1) - ry / 2;
//        temp.z = cp.get(2) + rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        //titik 8 kanan atas depan
//        temp.x = cp.get(0) + rx / 2;
//        temp.y = cp.get(1) + ry / 2;
//        temp.z = cp.get(2) + rz / 2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        vertices.clear();
//        //kotak yg sisi belakang
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(3));
//        //kotak yg sisi depan
//        vertices.add(tempVertices.get(4));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
//        vertices.add(tempVertices.get(7));
//        //kotak yg sisi kiri
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(4));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(3));
//        //kotak yg sisi kanan
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
//        vertices.add(tempVertices.get(2));
//        //kotak yg sisi atas
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(4));
//        //kotak yg sisi bawah
//        vertices.add(tempVertices.get(3));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(6));
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createPrism(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) - ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) - ry / 2.0f;
        temp.z = cp.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = cp.get(0) - rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = cp.get(0) + rx / 2.0f;
        temp.y = cp.get(1) + ry / 2.0f;
        temp.z = cp.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
//        //TITIK 7
//        temp.x = cp.get(0) + rx / 2.0f;
//        temp.y = cp.get(1) - ry / 2.0f;
//        temp.z = cp.get(2) + rz / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 8
//        temp.x = cp.get(0) - rx / 2.0f;
//        temp.y = cp.get(1) - ry / 2.0f;
//        temp.z = cp.get(2) + rz / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(1));
        //kotak yg sisi atas
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(2));

        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createCone() {
        this.vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList();

        for (double v = -Math.PI / 2; v <= 0; v += Math.PI / 360) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 360) {
                float x = 0.5f * (float) (v * Math.cos(u));
                float y = 0.5f * (float) (v * Math.sin(u));
                float z = 0.5f * (float) (v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        this.vertices = temp;
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createFrustumOfCone(float r1, float r2, float h) {
        this.vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList();
        for (double v = 0; v <= Math.PI; v += Math.PI / 360) {
            for (double u = 0; u <= Math.PI * 2; u += Math.PI / 360) {
                float x = (float) ((r1 - r2) / h * v * Math.cos(u) + r2 * Math.cos(u));
                float y = (float) ((r1 - r2) / h * v * Math.sin(u) + r2 * Math.sin(u));
                float z = (float) (h - (h * v / Math.PI));
                temp.add(new Vector3f(x, y, z));
            }
        }
        this.vertices = temp;
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createSphere() {
        vertices.clear();

        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 26;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i = 0; i <= stackCount; i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * sin(stackAngle));
            for(int j = 0; j < sectorCount; j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }

        // !!!
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i = 0; i < stackCount; i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j = 0; j < sectorCount; ++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }


            this.index = temp_indices;
            ibo = glGenBuffers();
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
        }
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createElipsoid(){
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        // u stackup angle
        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            x = rx * (float)Math.cos(StackAngle);
            y = rx * (float)Math.cos(StackAngle);
            z = rx * (float) sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = cp.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = cp.get(1) + y * (float) sin(sectorAngle);
                temp_vector.z = cp.get(2) + z;
                vertices.add(temp_vector);
            }
        }
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createHyperboloid1(){
        vertices.clear();
        float pi = (float)Math.PI;
        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        // u stackup angle
        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            z = rx * (float) (1.0 /Math.cos(StackAngle));
            y = ry * (float) (1.0/Math.cos(StackAngle));
            x = rz * (float) Math.tan(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.z = cp.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = cp.get(1) + y * (float) sin(sectorAngle);
                temp_vector.x = cp.get(2) + z;
                vertices.add(temp_vector);
            }
        }
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }
    public void createHyperboloid2(){
        vertices.clear();
        float pi = (float)Math.PI;
        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        // u stackup angle
        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            z = rx * (float) (Math.tan(StackAngle));
            y = ry * (float) (Math.tan(StackAngle));
            x = rz * (float) (1.0/Math.cos(StackAngle));

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.z = cp.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = cp.get(1) + y * (float) sin(sectorAngle);
                temp_vector.x = cp.get(2) + z;
                vertices.add(temp_vector);
            }
        }
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createTube(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 720) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 720) {
                float x = 0.5f * (float) (Math.sin(u));
                float y = 0.5f * (float) (Math.cos(u));
                float z = 0.5f * (float) v ;
                temp.add(new Vector3f(x, y, z));
            }
        }
        this.vertices = temp;
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createEParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = 0.5f * (float) (v * Math.cos(u));
                float y = 0.5f * (float) (v * Math.sin(u));
                float z = 0.5f * (float) (Math.pow(v,2));
                temp.add(new Vector3f(x, y, z));
            }
        }
        this.vertices = temp;
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createRing(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 2* Math.PI /120; v += Math.PI /120) {
            for (double u = -Math.PI; u <= Math.PI ; u += Math.PI /120) {
                float x = 0.5f * (float) (Math.cos(u));
                float y = 0.5f * (float) (Math.sin(u));
                float z = 0.5f * (float) v ;
                temp.add(new Vector3f(x, y, z));
            }
        }
        this.vertices = temp;
        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }

    public void createJubah(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= 0; v += Math.PI / 720) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 720) {
                float x = 0.5f * (float) (v * Math.cos(u));
                float y = 0.5f * (float) v;
                float z = 0.5f * (float) v ;
                temp.add(new Vector3f(x, y, z));
            }
        }
        this.vertices = temp;

        normal = new ArrayList<>(Arrays.asList(
                //belakang
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                new Vector3f(0.0f,0.0f, -1.0f),
                //depan
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                new Vector3f(0.0f,0.0f, 1.0f),
                // kiri
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                new Vector3f(-1.0f,0.0f, 0.0f),
                // kanan
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                new Vector3f(1.0f,0.0f, 0.0f),
                // bawah
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                new Vector3f(0.0f,-1.0f, 0.0f),
                // atas
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f),
                new Vector3f(0.0f,1.0f, 0.0f)

        ));
    }
//    public void setupVAOVBO(){
//        super.setupVAOVBO();
//
//        //nbo
//        //set nbo
//        nbo = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, nbo);
//        glBufferData(GL_ARRAY_BUFFER,
//                Utils.listoFloat(normal),
//                GL_STATIC_DRAW);
//
////        uniformsMap.createUniform(
////                "lightColor");
////        uniformsMap.createUniform(
////                "lightPos");
//    }

    public void drawSetup(Camera camera, Projection projection){
        super.drawSetup(camera, projection);

        // Bind NBO
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glVertexAttribPointer(1,
                3, GL_FLOAT,
                false,
                0, 0);
//        uniformsMap.setUniform(
//                "lightColor",
//                new Vector3f(0.8f,0.8f,0.8f));
//        uniformsMap.setUniform(
//                "lightPos",
//                new Vector3f(0f,0.0f,0.0f));
        uniformsMap.setUniform("dirLight.direction", new Vector3f(-0.1f, -0.1f, -0.3f));
        uniformsMap.setUniform("dirLight.ambient", new Vector3f(0.05f, 0.05f, 0.05f));
        uniformsMap.setUniform("dirLight.diffuse", new Vector3f(0.4f, 0.4f, 0.4f));
        uniformsMap.setUniform("dirLight.specular", new Vector3f(0.5f, 0.5f, 0.5f));

        //posisi pointLight
        Vector3f[] _pointLightPosition = {
                new Vector3f(-0.1f, 3f, 2.5f),
                new Vector3f(-0.1f, 3f, 2.5f),
                new Vector3f(-0.1f, 3f, 2.5f),
                new Vector3f(-0.1f, 3f, 2.5f)
        };
        for(int i = 0; i < _pointLightPosition.length; i++){
            uniformsMap.setUniform("pointLights["+i+"].position", _pointLightPosition[i]);
            uniformsMap.setUniform("pointLights["+i+"].ambient", new Vector3f(0.2f, 0.2f, 0.2f));
            uniformsMap.setUniform("pointLights["+i+"].diffuse", new Vector3f(0.5f, 0.5f, 0.5f));
            uniformsMap.setUniform("pointLights["+i+"].specular", new Vector3f(0.9f, 0.9f, 0.9f));
            uniformsMap.setUniform("pointLights["+i+"].constant", 1.0f);
            uniformsMap.setUniform("pointLights["+i+"].linear", 0.09f);
            uniformsMap.setUniform("pointLights["+i+"].quadratic", 0.032f);



        };

        //warnaa ... harus lebih terang dari ambient

        //spotLight
        uniformsMap.setUniform("spotLight.position", camera.getPosition());
        uniformsMap.setUniform("spotLight.direction", camera.getDirection());
        uniformsMap.setUniform("spotLight.ambient", new Vector3f(0.1f, 0.1f, 0.1f));
        uniformsMap.setUniform("spotLight.diffuse", new Vector3f(1.0f, 1.0f, 1.0f));
        uniformsMap.setUniform("spotLight.specular", new Vector3f(1.0f, 1.0f, 1.0f));
        uniformsMap.setUniform("spotLight.constant", 1.0f);
        uniformsMap.setUniform("spotLight.linear", 0.09f);
        uniformsMap.setUniform("spotLight.quadratic", 0.09f);
        uniformsMap.setUniform("spotLight.cutOff", (float) Math.cos(Math.toRadians(12.5f)));
        uniformsMap.setUniform("spotLight.outerCutOff", (float) Math.cos(Math.toRadians(15f)));


        uniformsMap.setUniform("viewPos", camera.getPosition());
    }

//    public void draw(){
//        drawSetup();
//        glLineWidth(10);
//        glPointSize(10);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }
}
