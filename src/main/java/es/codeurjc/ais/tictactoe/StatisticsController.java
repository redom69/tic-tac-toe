package es.codeurjc.ais.tictactoe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {
	
	@Autowired
	private TicTacToeHandler handler;
	
	@RequestMapping("/stats")
	public String stats(Model model) {
		List<Player> jugadores = handler.getStatistics().getStatistics();
		model.addAttribute("jugadores", jugadores);
		return "estadisticas";
	}

}
