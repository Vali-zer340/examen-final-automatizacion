package cl.iplacex.automatizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ProductoIntegrationIT {

    @Test
    void debeCalcularCorrectamenteElTotalIntegrandoServicioYDatos() {
        ProductoService service = new ProductoService();

        double precioProducto = 2500;
        int cantidad = 4;

        double total = service.calcularTotal(precioProducto, cantidad);

        assertEquals(10000, total);
    }
}