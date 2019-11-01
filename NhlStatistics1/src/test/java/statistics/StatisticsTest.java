package statistics;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import ohtuesimerkki.*;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void constructor() {
        new Statistics(readerStub);
    }

    @Test
    public void playerSearchNull() {
        assertEquals(null, stats.search("asd"));
    }

    @Test
    public void playerSearchNotNull() {
        assertEquals("Semenko", stats.search("Semenko").getName());
    }

    @Test
    public void teamEDM() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void teamPIT() {
        assertEquals(1, stats.team("PIT").size());
    }

    @Test
    public void topScorers() {
        List<Player> players = stats.topScorers(1);
        assertEquals("Gretzky", players.get(0).getName());
    }
}