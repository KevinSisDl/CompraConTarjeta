import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Compra implements Comparable<Compra> {
    private double valor;
    private String descripcion;
    private LocalDate fecha;

    public Compra(double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
    }

    public Compra(double valor, String descripcion, LocalDate fecha){
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Compra: valor=" + valor +
                ", descripcion='" + descripcion + ", Fecha= " + fecha;
    }

    @Override
    public int compareTo(Compra otraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(otraCompra.getValor()));
    }
}