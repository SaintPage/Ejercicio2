//Clase especificamente de Huesped, donde va los getters y setters de las propiedades
public class Huesped {
    private String nombre;
    private int visitas;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    @Override
    public String toString() {
        return this.nombre + ", numero de visitas:" + this.visitas;
    }
}
