package cl.iplacex.automatizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ProductoAcceptanceAT {

    @Test
    void clienteDebeObtenerTotalCorrectoDeUnaCompra() {
        ProductoService service = new ProductoService();

        double precio = 3990;
        int cantidad = 3;

        double total = service.calcularTotal(precio, cantidad);

        assertEquals(11970, total);
    }

    @Test
    void sistemaDebeRechazarUnaCantidadNegativa() {
        ProductoService service = new ProductoService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(2500, -1)
        );
    }
}