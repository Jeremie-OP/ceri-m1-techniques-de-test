package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;

    PokedexFactory pokedexFactory;

    @BeforeEach
    void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void createTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("jeanjean",Team.MYSTIC, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("jeanjean", trainer.getName());
        assertEquals(Team.MYSTIC,trainer.getTeam());
        assertNotNull(trainer.getPokedex());
    }
}