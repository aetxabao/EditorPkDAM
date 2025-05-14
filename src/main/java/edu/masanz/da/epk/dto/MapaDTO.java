package edu.masanz.da.epk.dto;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MapaDTO implements Comparable<MapaDTO> {

    private long id;
    private int orden;
    private String nombre;

    public MapaDTO() {
        this(0,0,"");
    }

    public MapaDTO(long id, int orden, String nombre) {
        this.id = id;
        this.orden = orden;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MapaDTO mapaDTO = (MapaDTO) o;
        return id == mapaDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(@NotNull MapaDTO other) {
        if (other ==null) return -1;
        return this.orden - other.orden;
    }

    public String toJson() {
        return "{ \"id\": " + id + ", \"orden\": " + orden + ", \"nombre\": \"" + nombre + "\" }";
    }

    @Override
    public String toString() {
        return toJson();
    }

    public static void main(String[] args) {
        MapaDTO mapaDTO = new MapaDTO(1, 2, "Mapa 1");
        System.out.println(mapaDTO.toJson());
    }

}
