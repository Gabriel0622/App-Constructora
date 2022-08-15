package model.vo;

public class ReporteProyectoVo {
	private int id;
	private String constructora;
	private int numeroHabitaciones;
	private String ciudad;
	
	public ReporteProyectoVo(int id, String constructora, int numeroHabitaciones, String ciudad) {
		this.id = id;
		this.constructora = constructora;
		this.numeroHabitaciones = numeroHabitaciones;
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return id+ "]  ["+constructora+ "]  ["+numeroHabitaciones+"]  ["+ciudad+"]";
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public int getId() {
		return id;
	}
	
	public String getConstructora() {
		return constructora;
	}
	
	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}
	
}
