package com.iteso.greenwar.Trash;
/**
 * This class defines the atributes of the object "Basura".
 * @author FrankDLT
 * @version 06/04/2020/1.0
 * */
public class Basura {
    /**
     * Nombre de la instancia de basura.
     * @author Francisco De La Torre
     * */
    private String name;
    /**
     * Nombre de la Clasificación.
     * @author Francisco De La Torre
     * */
    private String clasification;
    /**
     * Nombre de la clasificación por dificultad.
     * @author Francisco De La Torre
     * */
    private String clas;

    /**
     * Metodo para obtener el nombre.
     * @author Francisco De La Torre
     * @return Nombre de la basura
     * */
    public String getName() {
        return name;
    }

    /**
     * Metodo para asignar valor del nombre.
     * @author Francisco De La Torre
     * @param newna nuevo nombre
     * */
    public void setName(final String newna) {
        this.name = newna;
    }

    /**
     * Metodo para obtener la clasificación.
     * @author Francisco De La Torre
     * @return Nombre de la clasificación
     * */
    public String getClasification() {
        return clasification;
    }

    /**
     * Metodo para asignar valor de la clasificación.
     * @author Francisco De La Torre
     * @param newcla nueva clasificación
     * */
    public void setClasification(final String newcla) {
        this.clasification = newcla;
    }

    /**
     * Metodo para obtener la clasificación por dificultad.
     * @author Francisco De La Torre
     * @return Nombre de la clasificación por dificultad
     * */
    public String getClas() {
        return clas;
    }

    /**
     * Metodo para asignar valor de la
     * clasificación por dificultad.
     * @author Francisco De La Torre
     * @param neuclas nueva clasificación
     *                por dificultad
     * */
    public void setClas(final String neuclas) {
        this.clas = neuclas;
    }
}
