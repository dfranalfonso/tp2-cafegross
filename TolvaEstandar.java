package com.cafegross;

/**
 * Subclase para tolvas convencionales de café con rotación estándar.
 */
public class TolvaEstandar extends TolvaCafe {
    private int tiempoAlmacenamientoMax; // en días

    public TolvaEstandar(int numeroTolva, String origen, double pesomax, int tiempoAlmacenamientoMax) {
        super(numeroTolva, origen, pesomax);
        this.tiempoAlmacenamientoMax = tiempoAlmacenamientoMax;
    }

    public int getTiempoAlmacenamientoMax() {
        return tiempoAlmacenamientoMax;
    }

    @Override
    public String getEstado() {
        return String.format("Tolva Estándar #%d [%s] - Stock: %.2f / %.2f kg (Máx días: %d)",
                numeroTolva, origen, kilosActuales, pesomax, tiempoAlmacenamientoMax);
    }
}
