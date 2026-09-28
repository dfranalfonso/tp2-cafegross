package com.cafegross;

/**
 * Subclase especializada para café de especialidad con control atmosférico.
 */
public class TolvaHermetica extends TolvaCafe {
    private double presionAtmosferica;
    private double nivelHumedadMax;

    public TolvaHermetica(int numeroTolva, String origen, double pesomax, double presionAtmosferica, double nivelHumedadMax) {
        super(numeroTolva, origen, pesomax);
        this.presionAtmosferica = presionAtmosferica;
        this.nivelHumedadMax = nivelHumedadMax;
    }

    @Override
    public boolean ingresarCarga(double kilos) {
        if (this.presionAtmosferica > 1.15) {
            System.out.println("Alerta crítica: Presión interna elevada (" + presionAtmosferica + " atm). Compuerta bloqueada por seguridad.");
            return false;
        }
        return super.ingresarCarga(kilos);
    }

    public double getPresionAtmosferica() {
        return presionAtmosferica;
    }

    public double getNivelHumedadMax() {
        return nivelHumedadMax;
    }

    @Override
    public String getEstado() {
        return String.format("Tolva Hermética #%d [%s] - Stock: %.2f / %.2f kg (Presión: %.2f atm, Humedad máx: %.1f%%)",
                numeroTolva, origen, kilosActuales, pesomax, presionAtmosferica, nivelHumedadMax);
    }
}
