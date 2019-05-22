package es.codeurjc.ais.tictactoe;

public class Player {

	private String label;
	private String name;
	private int id;
	private int pganadas;
	private int pperdidas;
	private int pempatadas;

	public Player(int id, String label, String name) {
		this.id = id;
		this.label = label;
		this.name = name;
		this.pempatadas = 0;
		this.pperdidas = 0;
		this.pganadas = 0;
	}

	public String getLabel() {
		return label;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPganadas() {
		return pganadas;
	}

	public void setPganadas(int pganadas) {
		this.pganadas = pganadas;
	}

	public int getPperdidas() {
		return pperdidas;
	}

	public void setPperdidas(int pperdidas) {
		this.pperdidas = pperdidas;
	}

	public int getPempatadas() {
		return pempatadas;
	}

	public void setPempatadas(int pempatadas) {
		this.pempatadas = pempatadas;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void anadirGanadas() {
		this.pganadas++;
	}
	
	public void anadirPerdidas() {
		this.pperdidas++;
	}
	public void anadirEmpatadas() {
		this.pempatadas++;
	}
	@Override 
	 public boolean equals(Object o) { 
		 if (this == o) { 
			 return true; 
		 } 
		 if (o == null) { 
			 return false; 
		 } 
		 if (getClass() != o.getClass()) { 
	            return false; 
		 } 
	        Player p = (Player) o; 
	        return (p.getName().equals(getName()))&&(p.getLabel().equals(getLabel()));
	} 
}
