package org.example.Hoteleria;

import org.example.Interfaces.IEstado;

public class Hoteleria implements IEstado {
        private String tipo;
        private boolean estado;

        public Hoteleria() {
        }

        public Hoteleria(String tipo, boolean estado) {
            this.tipo = tipo;
            this.estado = estado;
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
