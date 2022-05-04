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
        IPokedex pokedex = new Pokedex();
        pokedex.addPokemon(new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56));
        pokemonMetadataProvider = pokedex;
    }


    @Test
    void getPokemonMetadata() {
        assertDoesNotThrow(() -> {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(0);
        });
        assertThrows(PokedexException.class,() -> {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(-1);
        });
    }
}