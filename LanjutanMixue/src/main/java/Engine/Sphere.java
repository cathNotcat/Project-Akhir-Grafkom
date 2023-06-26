package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Sphere extends Circle{
    Float radiusZ;
    int sectorCount;


    List<Integer> index;
    List<Vector3f> normal;
    int nbo;
    public Vector3f cp;
    int ibo;
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color,
                  Vector3f cp, Float rx, Float ry, Float radiusZ) {
        super(shaderModuleDataList, vertices, color, cp, rx, ry);
        this.radiusZ = radiusZ;
        this.cp=cp;
        vertices.clear();
        createBox();
        setupVAOVBO();
    }

    public Sphere() {
        super(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ));
    }

    public List<Vector3f> getNormal() {
        return normal;
    }

    public void setNormal(List<Vector3f> normal) {
        this.normal = normal;
        setupVAOVBO();
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


    public void createBox(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //Titik 1 kiri atas belakang
        temp.x = cp.get(0) - rx / 2;
        temp.y = cp.get(1) + ry / 2;
        temp.z = cp.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 2 kiri bawah belakang
        temp.x = cp.get(0) - rx / 2;
        temp.y = cp.get(1) - ry / 2;
        temp.z = cp.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 3 kanan bawah belakang
        temp.x = cp.get(0) + rx / 2;
        temp.y = cp.get(1) - ry / 2;
        temp.z = cp.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 4 kanan atas belakang
        temp.x = cp.get(0) + rx / 2;
        temp.y = cp.get(1) + ry / 2;
        temp.z = cp.get(2) - radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 5 kiri atas depan
        temp.x = cp.get(0) - rx / 2;
        temp.y = cp.get(1) + ry / 2;
        temp.z = cp.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 6 kiri bawah depan
        temp.x = cp.get(0) - rx / 2;
        temp.y = cp.get(1) - ry / 2;
        temp.z = cp.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 7 kanan bawah depan
        temp.x = cp.get(0) + rx / 2;
        temp.y = cp.get(1) - ry / 2;
        temp.z = cp.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();
        //Titik 8 kanan atas depan
        temp.x = cp.get(0) + rx / 2;
        temp.y = cp.get(1) + ry / 2;
        temp.z = cp.get(2) + radiusZ / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

//        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        //kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        //kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
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
    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        //titik persegi
        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
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
        }

        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);

    }

    public void createHalfEllipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI/2; u<= Math.PI/1.99; u+=Math.PI/90){
                float x = 0.6f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createEllipsoid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/90){
                float x = 0.6f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticCylinder(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/90){
                float x = 0.5f * (float)(Math.sin(u));
                float y = 0.5f * (float)(Math.cos(u));
                float z = 0.5f * (float) v;
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHyeperboloid2side(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(Math.tan(v) * Math.cos(u));
                float y = 0.1f * (float)(Math.tan(v) * Math.sin(u));
                float z = 0.1f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,z,y));
            }

        }
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60) {
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = 0.3f * (float) (Math.tan(v) * Math.cos(u));
                float y = 0.3f * (float) (Math.tan(v) * Math.sin(u));
                float z = -0.3f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, z, y));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticCone(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/90){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/90){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = 0.5f * (float)(v);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createElipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.005){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHalfElipticParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.005){
            for(double u = -Math.PI; u<= Math.PI/100; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHalfElipticParaboloid2(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.005){
            for(double u = -Math.PI/200; u<= Math.PI; u+=Math.PI/60){
                float x = 0.5f * (float)(v * Math.cos(u));
                float y = 0.5f * (float)(v * Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(z,y,x));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void createHyperboloidParaboloid(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 1; v+=0.05){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.2f * (float)(v * Math.tan(u));
                float y = 0.2f * (float)(v * 1/Math.sin(u));
                float z = (float) Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices.clear();
        vertices = temp;
    }

    public void setupVAOVBO(){
        super.setupVAOVBO();

        //nbo
        //set nbo
        nbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, nbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(normal),
                GL_STATIC_DRAW);

//        uniformsMap.createUniform(
//                "lightColor");
//        uniformsMap.createUniform(
//                "lightPos");
    }
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
//                new Vector3f(1.0f,1.0f,0.0f));
//        uniformsMap.setUniform(
//                "lightPos",
//                new Vector3f(1.0f,1.0f,0.0f));
        uniformsMap.setUniform("dirLight.direction", new Vector3f(-0.2f, -1.0f, -0.3f));
        uniformsMap.setUniform("dirLight.ambient", new Vector3f(0.05f, 0.05f, 0.05f));
        uniformsMap.setUniform("dirLight.diffuse", new Vector3f(0.4f, 0.4f, 0.4f));
        uniformsMap.setUniform("dirLight.specular", new Vector3f(0.5f, 0.5f, 0.5f));

        //posisi pointLight
        Vector3f[] _pointLightPosition = {
                new Vector3f(0f, 0f, 0f),
                new Vector3f(0f, 0f, 0f),
                new Vector3f(0f, 0f, 0f),
                new Vector3f(0f, 0f, 0f)
        };
        for(int i = 0; i < _pointLightPosition.length; i++){
            uniformsMap.setUniform("pointLights["+i+"].position", _pointLightPosition[i]);
            uniformsMap.setUniform("pointLights["+i+"].ambient", new Vector3f(0.5f, 0.5f, 0.5f));
            uniformsMap.setUniform("pointLights["+i+"].diffuse", new Vector3f(0.8f, 0.8f, 0.8f));
            uniformsMap.setUniform("pointLights["+i+"].specular", new Vector3f(1.0f, 1.0f, 1.0f));
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
//    public void draw(Camera camera, Projection projection){
//        drawSetup(camera,projection);
//        // Draw the vertices
//        //optional
//        glLineWidth(10); //ketebalan garis
//        glPointSize(10); //besar kecil vertex
//        //wajib
//        //GL_LINES
//        //GL_LINE_STRIP
//        //GL_LINE_LOOP
//        //GL_TRIANGLES
//        //GL_TRIANGLE_FAN
//        //GL_POINT
////        glDrawArrays(GL_POLYGON,
////                0,
////                vertices.size());
//        //draw indicies
//        glDrawElements(GL_TRIANGLES,
//                index.size(),GL_UNSIGNED_INT,0);
//        for (Object child: childObject){
//            child.draw(camera,projection);
//        }
//    }
//    public void draw(){
//        drawSetup();
//        //Bind IBO & draw
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_TRIANGLES,
//                index.size(),
//                GL_UNSIGNED_INT, 0);
//    }
//
//    public void drawLine(){
//        drawSetup();
//        // Draw the vertices
//        glLineWidth(1);
//        glPointSize(1);
//        glDrawArrays(GL_LINE_STRIP, 0,
//                vertices.size());
//    }
}