package edu.masanz.da.epk.dto;

public class MapaDataDTO extends MapaDTO {

    private final static int FILAS = 40;
    private final static int COLUMNAS = 30;

    private final static int TIERRA = 0;
    private final static int PARED = 4;

    private String surfaces;
    private String elements;

    public MapaDataDTO() {
        super();
        this.surfaces = initData();
        this.elements = initData();
    }

    public MapaDataDTO(long id, int orden, String nombre,
                       String surfaces, String elements) {
        super(id, orden, nombre);
        this.surfaces = surfaces;
        this.elements = elements;
    }

    private String initData() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if ((i==0 || i==FILAS-1) || (j==0 || j==COLUMNAS-1)) {
                    sb.append(PARED).append(' ');
                } else {
                    sb.append(TIERRA).append(' ');
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public String toArray(String matriz) {
        // 4 4 4
        // 4 0 4
        // 4 0 4
        // 4 4 4
        StringBuilder sb = new StringBuilder();
        // '4', '4', '4', '4', '0', '4', '4', '0', '4', '4', '4', '4'
        String[] a = matriz.split("\\s+");
        for (String s : a) {
            sb.append("'").append(s).append("', ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public String getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(String surfaces) {
        this.surfaces = surfaces;
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }


    public String getSurfacesArray() {
        return toArray(surfaces);
    }

    public String getElementsArray() {
        return toArray(elements);
    }

    public static void main(String[] args) {
        MapaDataDTO mapa = new MapaDataDTO();
        System.out.println(mapa.getSurfacesArray());
        System.out.println("-".repeat(80));
        System.out.println(mapa.getElementsArray());
    }

}
