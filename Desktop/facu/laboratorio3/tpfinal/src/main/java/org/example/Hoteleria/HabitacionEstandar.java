package org.example.Hoteleria;

public class HabitacionEstandar extends Hoteleria{

    private static final String estado = "Habitacion Estandar";
    public HabitacionEstandar(boolean estado, double precio) {
        super(estado, precio);
    }

    @Override
    public void cambioEstado() {
        if(super.isEstado())
        {
            super.setEstado(false);
        }else
        {
            super.setEstado(true);
        }
    }

    public String toString() {
        return "Habitacion Estandar" + "\n" +
                "" + super.toString();
    }
}
