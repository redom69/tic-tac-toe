package es.codeurjc.ais.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Before;
import org.junit.Test;

import es.codeurjc.ais.tictactoe.Board;



public class PruebasUnitarias {
	
	private Board board;
	
	
	@Before
	public void setUp() {
		board=new Board();
		board.enableAll();
	}
	
	@Test
	public void ganaElX_NoGanaElO_noHayEmpate() {
		int[] lista= {0,1,2};
		board.getCell(0).value="X";
		board.getCell(0).active=false;
		board.getCell(3).value="O";
		board.getCell(3).active=false;
		board.getCell(1).value="X";
		board.getCell(1).active=false;
		board.getCell(4).value="O";
		board.getCell(4).active=false;
		board.getCell(2).value="X";
		board.getCell(2).active=false;
		assertThat(board.getCellsIfWinner("X")).isEqualTo(lista);
		assertThat(board.getCellsIfWinner("O")).isEqualTo(null);
		assertThat(board.checkDraw()).isEqualTo(false);
	}
	
	@Test
	public void empate_noGanaElX_noGanaElO() {
		board.getCell(0).value="X";
		board.getCell(0).active=false;
		board.getCell(1).value="O";
		board.getCell(1).active=false;
		board.getCell(3).value="X";
		board.getCell(3).active=false;
		board.getCell(4).value="O";
		board.getCell(4).active=false;
		board.getCell(7).value="X";
		board.getCell(7).active=false;
		board.getCell(6).value="O";
		board.getCell(6).active=false;
		board.getCell(2).value="X";
		board.getCell(2).active=false;
		board.getCell(5).value="O";
		board.getCell(5).active=false;
		board.getCell(8).value="X";
		board.getCell(8).active=false;
		assertThat(board.getCellsIfWinner("X")).isEqualTo(null);
		assertThat(board.getCellsIfWinner("O")).isEqualTo(null);
		assertThat(board.checkDraw()).isEqualTo(true);
	}
	
	@Test
	public void ganaElO_NoGanaElX_noHayEmpate() {
		int[] lista= {3,4,5};
		board.getCell(0).value="X";
		board.getCell(0).active=false;
		board.getCell(3).value="O";
		board.getCell(3).active=false;
		board.getCell(1).value="X";
		board.getCell(1).active=false;
		board.getCell(4).value="O";
		board.getCell(4).active=false;
		board.getCell(6).value="X";
		board.getCell(6).active=false;
		board.getCell(5).value="O";
		board.getCell(5).active=false;
		
		
		assertThat(board.getCellsIfWinner("O")).isEqualTo(lista);
		assertThat(board.getCellsIfWinner("X")).isEqualTo(null);
		assertThat(board.checkDraw()).isEqualTo(false);
	}
	
}
