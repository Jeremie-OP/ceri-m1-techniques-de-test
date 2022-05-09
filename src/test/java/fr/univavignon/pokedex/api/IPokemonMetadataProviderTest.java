package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    void setUp() {
        pokemonMetadataProvider = new PokemonMetadataProvider();
    }


    @Test
    void getPokemonMetadata() {
        assertDoesNotThrow(() -> {
            PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(0, metadata.getIndex());
        });
    }
    @Test
    void getPokemonMetadataWrongID() {
        assertThrows(PokedexException.class,() -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }

    @Test
    void getPokemonMetadataHighID() {
        assertThrows(PokedexException.class,() -> pokemonMetadataProvider.getPokemonMetadata(500));
    }
}