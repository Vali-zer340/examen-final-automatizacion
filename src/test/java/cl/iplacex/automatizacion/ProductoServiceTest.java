package cl.iplacex.automatizacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ProductoServiceTest {

    @Test
    void calcularTotalDebeMultiplicarPrecioPorCantidad() {
        ProductoService service = new ProductoService();

        double resultado = service.calcularTotal(1500, 3);

        assertEquals(4500, resultado);
    }

    @Test
    void calcularTotalDebeRechazarPrecioNegativo() {
        ProductoService service = new ProductoService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.calcularTotal(-1000, 2)
        );
    }
}