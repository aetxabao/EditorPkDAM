package edu.masanz.da.epk.dto;

public class MapaDataDTO extends MapaDTO {

    private final static int FILAS = 40;
    private final static int COLUMNAS = 30;

    private String surfaces;
    private String elements;

    public MapaDataDTO() {
        super();
        this.surfaces = "";
        this.elements = "";
    }


}
