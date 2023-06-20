package org.example.Hoteleria;

public class HabitacionFamiliar extends Hoteleria{

    private static final String estado = "Habitacion Familiar";
    public HabitacionFamiliar(boolean estado, double precio) {
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
        return "Habitacion Familiar" + "\n" +
                "" + super.toString();
    }
}
