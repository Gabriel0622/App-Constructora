package model.vo;

public class ReporteCompraVo {
	private int id;
	private String constructora;
	private String banco;
	public ReporteCompraVo(int id, String constructora, String banco) {
		super();
		this.id = id;
		this.constructora = constructora;
		this.banco = banco;
	}
	
	@Override
	public String toString() {
		return "["+id+"]  ["+constructora+"]  ["+banco+"]";
	}
	
	public int getId() {
		return id;
	}
	public String getConstructora() {
		return constructora;
	}
	public String getBanco() {
		return banco;
	}
}
