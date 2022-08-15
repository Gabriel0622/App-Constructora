package model.vo;

public class ReporteLiderVo {
	private int id;
	private String lider;
	private String ciudad;
	public ReporteLiderVo(int id, String lider, String ciudad) {
		this.id = id;
		this.lider = lider;
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "["+id+ "]  ["+ lider+ "]   ["+ ciudad+"]";
	}
	
	public int getId() {
		return id;
	}
	public String getLider() {
		return lider;
	}
	public String getCiudad() {
		return ciudad;
	}

}
