package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;


class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Mock
    private Pokedex pokedexMocked;

    @BeforeEach
    void setUp() {
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void createPokedex() {
        Pokedex pokedex = (Pokedex) pokedexFactory.createPokedex(pokedexMocked, pokedexMocked);
        assertNotNull(pokedex);
    }
}