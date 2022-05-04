package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


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