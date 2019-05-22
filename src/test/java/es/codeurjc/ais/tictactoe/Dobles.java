package es.codeurjc.ais.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;


import org.hamcrest.Matchers;
import org.hamcrest.Matcher;

import static org.mockito.Mockito.*;

import java.util.Collection;

import static org.mockito.ArgumentMatchers.argThat;
import static org.hamcrest.Matchers.*;




public class Dobles {
	
	private TicTacToeGame tttg;
	private Connection c1;
	private Connection c2;
	
	@Before
	public void init() {

		//Crear Objeto TicTacToeGame
		tttg=new TicTacToeGame();
		//Crear Dobles de Connection
		c1=mock(Connection.class);
		c2=mock(Connection.class);
	}
	
	
	@Test
	public void ganaElX() {
		//Añadir connection a tictactoegame
		tttg.addConnection(c1);
		tttg.addConnection(c2);
		//Crear los dos Jugadores
		Player p0=new Player(0,"X","Paloma");
		Player p1=new Player(1,"O","Francisco");
		//Añadir los jugadores a tictactoegame
		tttg.addPlayer(p0);
		tttg.addPlayer(p1);
		//Comprobar que las conexiones reciben el evento JOIN_GAME
		//verify(c1).sendEvent(eq(EventType.JOIN_GAME), argThat( (ArgumentMatcher<Player>) hasItems(p0,p1)));
		//verify(c2).sendEvent(eq(EventType.JOIN_GAME),argThat((ArgumentMatcher<Player>) hasItems(p0, p1)));
		
		//Cada jugador va marcando y comprueba que el turno cambia
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat((ArgumentMatcher<Player>) hasItem(p0)));
		tttg.mark(0);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(1);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(3);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(4);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(6);
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	}
	
	@Test
	public void ganaElO() {
		
		
		//Añadir connection a tictactoegame
		tttg.addConnection(c1);
		tttg.addConnection(c2);
		//Crear los dos Jugadores
		Player p0=new Player(0,"X","Paloma");
		Player p1=new Player(1,"O","Francisco");
		//Añadir los jugadores a tictactoegame
		tttg.addPlayer(p0);
		tttg.addPlayer(p1);
		//Comprobar que las conexiones reciben el evento JOIN_GAME
		//verify(c1).sendEvent(eq(EventType.JOIN_GAME), argThat( (ArgumentMatcher<Player>) hasItems(p0,p1)));
		//verify(c2).sendEvent(eq(EventType.JOIN_GAME),argThat((ArgumentMatcher<Player>) hasItems(p0, p1)));
		
		//Cada jugador va marcando y comprueba que el turno cambia
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat((ArgumentMatcher<Player>) hasItem(p0)));
		tttg.mark(0);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(1);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(3);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(4);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(2);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(7);
		ArgumentCaptor<WinnerValue> argument = ArgumentCaptor.forClass(WinnerValue.class);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	}
	
	
	@Test
	public void empate() {
		
		
		//Añadir connection a tictactoegame
		tttg.addConnection(c1);
		tttg.addConnection(c2);
		//Crear los dos Jugadores
		Player p0=new Player(0,"X","Paloma");
		Player p1=new Player(1,"O","Francisco");
		//Añadir los jugadores a tictactoegame
		tttg.addPlayer(p0);
		tttg.addPlayer(p1);
		//Comprobar que las conexiones reciben el evento JOIN_GAME
		//verify(c1).sendEvent(eq(EventType.JOIN_GAME), argThat( (ArgumentMatcher<Player>) hasItems(p0,p1)));
		//verify(c2).sendEvent(eq(EventType.JOIN_GAME),argThat((ArgumentMatcher<Player>) hasItems(p0, p1)));
		
		//Cada jugador va marcando y comprueba que el turno cambia
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat((ArgumentMatcher<Player>) hasItem(p0)));
		tttg.mark(0);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(1);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(3);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(4);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(7);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(6);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(2);
		//verify(c2).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(5);
		//verify(c1).sendEvent(eq(EventType.SET_TURN), argThat(hasItem(p0)));
		tttg.mark(8);
		verify(c1).sendEvent(eq(EventType.GAME_OVER), eq(null));
	}
	
	
	
}
