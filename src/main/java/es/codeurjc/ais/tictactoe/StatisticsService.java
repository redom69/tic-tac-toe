package es.codeurjc.ais.tictactoe;

import java.util.ArrayList;

public class StatisticsService {
	
	private ArrayList<Player> statistics;
	
	public StatisticsService() {
		statistics = new ArrayList<Player>();
	}

	public ArrayList<Player> getStatistics() {
		return statistics;
	}

	public void setStatistics(ArrayList<Player> statistics) {
		this.statistics = statistics;
	}
	
	public void partidaGanada(Player player) {
		statistics.get(statistics.indexOf(player)).anadirGanadas();
	}
	public void partidaPerdida(Player player) {
		statistics.get(statistics.indexOf(player)).anadirPerdidas();
	}
	public void partidaEmpatada(Player player) {
		statistics.get(statistics.indexOf(player)).anadirEmpatadas();
	}

}
