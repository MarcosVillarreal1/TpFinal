package org.example.Hoteleria;

import org.example.Interfaces.IEstado;

public class Hoteleria implements IEstado {
        private String tipo;
        private boolean estado;
        private String descripcion;


        public Hoteleria() {
        }

        public Hoteleria(String tipo, boolean estado, String descripcion) {
            this.tipo = tipo;
            this.estado = estado;
            this.descripcion = descripcion;
        }

        public Hoteleria(String tipo, boolean estado, double precio) {
            this.tipo = tipo;
            this.estado = estado;
            this.descripcion = descripcion;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public boolean getEstado() {
            return estado;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public void cambioEstado() {
            if (getEstado()) {
                setEstado(false);
            } else {
                setEstado(true);
            }
        }

        @Override
        public String toString() {
            return "Estado: " + estado + "\n";
        }

}
