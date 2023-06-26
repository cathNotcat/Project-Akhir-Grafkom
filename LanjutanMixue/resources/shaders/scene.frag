#version 330

out vec4 fragColor;
uniform vec4 uni_color;

uniform vec3 lightPos;
uniform vec3 lightColor;
in vec3 Normal;
in vec3 FragPos;
void main()
{
    //vec4(red,green,blue,alpha)
    //rgba -> red 100/255
    //fragColor = vec4(1.0,0.0,0.0,1.0);
    //ambient
    float ambientStrength = 0.1f;
    vec3 ambient = ambientStrength * lightColor;
    //diffuse
    vec3 lightDirection = normalize(lightPos - FragPos);
    float diff =max(dot(Normal, lightDirection),0.0);
    vec3 diffuse = diff * lightColor;

    //
    vec3 result = (ambient+diffuse) * vec3(uni_color);
    fragColor = vec4(result,1.0);
}
