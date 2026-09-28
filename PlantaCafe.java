package com.cafegross;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase controladora y coordinadora de las operaciones en planta de Café Gross.
 */
public class PlantaCafe {
    private String nombre;
    private List<TolvaCafe> tolvas;

    public PlantaCafe(String nombre) {
        this.nombre = nombre;
        this.tolvas = new ArrayList<>();
    }

    public void agregarTolva(TolvaCafe tolva) {
        this.tolvas.add(tolva);
    }

    public void cargarTolva(int numeroTolva, double kilos) {
        for (TolvaCafe t : tolvas) {
            if (t.getNumeroTolva() == numeroTolva) {
                t.ingresarCarga(kilos);
                return;
            }
        }
        System.out.println("Error: Tolva N° " + numeroTolva + " no encontrada en planta.");
    }

    public void descargarTolva(int numeroTolva, double kilos) {
        for (TolvaCafe t : tolvas) {
            if (t.getNumeroTolva() == numeroTolva) {
                t.descargarCarga(kilos);
                return;
            }
        }
        System.out.println("Error: Tolva N° " + numeroTolva + " no encontrada.");
    }

    public double calcularStockTotal() {
        double total = 0.0;
        for (TolvaCafe t : tolvas) {
            total += t.getKilosActuales();
        }
        return total;
    }

    public List<TolvaCafe> getTolvas() {
        return tolvas;
    }

    public boolean hayTolvasDisponibles() {
        for (TolvaCafe t : tolvas) {
            if (t.estaDisponible()) return true;
        }
        return false;
    }

    public void mostrarEstadoTolvas() {
        System.out.println("=== ESTADO DE PLANTA: " + nombre + " ===");
        for (TolvaCafe t : tolvas) {
            System.out.println(t.getEstado());
        }
        System.out.println("Stock total acumulado: " + calcularStockTotal() + " kg");
    }
}
