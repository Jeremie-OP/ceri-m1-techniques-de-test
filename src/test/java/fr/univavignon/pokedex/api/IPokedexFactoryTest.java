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

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    void setUp() {
        pokedexFactory = new PokedexFactory();
    }

    @Test
    void createPokedex() {
        IPokedex newPokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        assertNotNull(newPokedex);
    }
}