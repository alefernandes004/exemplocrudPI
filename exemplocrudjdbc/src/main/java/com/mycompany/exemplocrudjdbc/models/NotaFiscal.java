package com.mycompany.exemplocrudjdbc.models;

/**
 *
 * @author fernando.tfernandes
 */
public class NotaFiscal {
    
    private int idNota;
    private int numeroNota;
    private double valorNota;

    public NotaFiscal(int numeroNota, double valorNota) {
        this.numeroNota = numeroNota;
        this.valorNota = valorNota;
    }

    public NotaFiscal(int idNota, int numeroNota, double valorNota) {
        this.idNota = idNota;
        this.numeroNota = numeroNota;
        this.valorNota = valorNota;
    }
    
    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }
    
    
    
}
