package test.practica9.b;

/**
 * Config
 */
public class Config {
    private String NAME, URL, USUARIO, CONTRASENA;
    private static Config;
    public Config(){

    }

    private static Config getInstance(){
        return config == null ? config = new Config() : config;


    }

    private void printInstance(){
        System.out.println(NAME + "," + url + ", ")+USUARIO + ", "+ CONTRASENA;
    }

    

    
}

