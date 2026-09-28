package com.cafegross;

/**
 * Clase base abstracta que modela los contenedores de acopio en planta.
 */
public abstract class TolvaCafe {
    protected int numeroTolva;
    protected String origen;
    protected double pesoMaximo;
    protected double kilosActuales;
    protected boolean estadoOperativo;

    public TolvaCafe(int numeroTolva, String origen, double pesoMaximo) {
        this.numeroTolva = numeroTolva;
        this.origen = origen;
        this.pesoMaximo = pesoMaximo;
        this.kilosActuales = 0.0;
        this.estadoOperativo = true;
    }

    /**
     * Valida y registra el pesaje individual de un saco cumpliendo RF11 y RF12.
     */
    public boolean ingresarCarga(double kilos) {
        if (!this.estadoOperativo) {
            System.out.println("Alerta: La tolva N° " + numeroTolva + " está fuera de servicio.");
            return false;
        }

        // Validación de rango por saco entre 10 kg a 70 kg
        if (kilos < 10.0 || kilos > 70.0) {
            System.out.println("Rechazo de pesaje: Saco fuera del rango admisible (10 kg - 70 kg). Ingresado: " + kilos + " kg.");
            return false;
        }

        // Validación de sobrecarga estructural de la tolva
        if (this.kilosActuales + kilos > this.pesoMaximo) {
            System.out.println("Alerta de sobrecapacidad: Se supera el peso máximo de " + pesoMaximo + " kg.");
            return false;
        }

        this.kilosActuales += kilos;
        System.out.println("Carga exitosa: Se ingresaron " + kilos + " kg en Tolva N° " + numeroTolva + " (" + origen + ").");
        return true;
    }

    public boolean descargarCarga(double kilos) {
        if (kilos <= 0 || kilos > this.kilosActuales) {
            System.out.println("Descarga rechazada: Cantidad inválida.");
            return false;
        }
        this.kilosActuales -= kilos;
        return true;
    }

    public boolean verificarCapacidadDisponible(double kilos) {
        return (this.kilosActuales + kilos) <= this.pesoMaximo;
    }

    public double getKilosActuales() {
        return kilosActuales;
    }

    public int getNumeroTolva() {
        return numeroTolva;
    }

    public String getOrigen() {
        return origen;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public boolean estaDisponible() {
        return estadoOperativo && (kilosActuales < pesoMaximo);
    }

    public abstract String getEstado();
}
