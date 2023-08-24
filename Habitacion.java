// Clase donde van los getters y setters de las propiedades
public class Habitacion {
    private int maxOcupantes;
    private int precioNoche;
    private boolean ocupado;
    private Huesped huesped;
    private String tipo;

    private int categoria;

    public Habitacion(String tipo, int precio, int categoria){
        this.tipo = tipo;
        this.precioNoche = precio;
        this.categoria = categoria;
    }

    public int getMaxOcupantes(){
        return this.maxOcupantes;
    }
    public void setMaxOcupantes(int ocupantes){
        this.maxOcupantes = ocupantes;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "tipo: "+this.tipo +", categoria:"+this.categoria;
    }
}
