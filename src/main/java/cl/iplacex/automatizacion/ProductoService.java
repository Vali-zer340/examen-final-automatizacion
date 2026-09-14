package cl.iplacex.automatizacion;

public class ProductoService {

    public double calcularTotal(double precio, int cantidad) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        return precio * cantidad;
    }
}