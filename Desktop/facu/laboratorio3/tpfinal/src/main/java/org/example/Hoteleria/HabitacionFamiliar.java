package org.example.Hoteleria;

public class HabitacionFamiliar extends Hoteleria{

    private static double precio = 5000;
    private static final String tipo = "Habitacion Familiar";
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
