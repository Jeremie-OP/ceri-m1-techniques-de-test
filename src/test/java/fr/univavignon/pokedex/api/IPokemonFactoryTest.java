package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokemonFactory = new Pokedex();
    }

    @Test
    void createPokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertNotNull(pokemon);
        assertEquals(pokemon.getIndex(), 0);
    }
}