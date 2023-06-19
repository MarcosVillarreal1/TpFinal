package org.example.Hoteleria;

public class HabitacionPremium extends Hoteleria{

    private static double precio = 10000;

    private static final String tipo = "Habitacion Premium";
    public HabitacionPremium(boolean estado, double precio) {
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

    @Override
    public String toString() {
        return "Habitacion Premium" + "\n" +
                "" + super.toString();
    }
}
