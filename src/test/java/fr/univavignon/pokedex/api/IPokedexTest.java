package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class IPokedexTest {

    private IPokedex pokedex;

    private Pokemon pokemon0;

    private Pokemon pokemon133;

    @Mock
    private IPokemonFactory pokemonFactory;
    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    void setUp() {
        try {
            when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        }catch (Exception e) {
            e.printStackTrace();
        }
        pokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);
    }

    @Test
    void size() {
        int result = pokedex.size();
        pokedex.addPokemon(pokemon0);
        assertEquals(result + 1, pokedex.size());
    }

    @Test
    void addPokemon() {
        pokedex.addPokemon(pokemon0);
        int result = pokedex.addPokemon(pokemon133);
        assertEquals(1, result);

    }

    @Test
    void getPokemon() throws Exception {
        int pok = pokedex.addPokemon(pokemon133);
        assertEquals(0,pok);
        Pokemon result = pokedex.getPokemon(pok);
        assertEquals(pokemon133, result);
    }

    @Test
    void getPokemonExceptionWrongIntTest() {
        PokedexException thrown = assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
        assertTrue(thrown.getMessage().contains("pokemon"));
    }

    @Test
    void getPokemonExceptionNonExistTest(){
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(5000));
    }

    @Test
    void getPokemons() {
        List<Pokemon> listPokemons = pokedex.getPokemons();
        assertNotNull(listPokemons);
    }

    @Test
    void getPokemonMetadata() {
        try {
            PokemonMetadata result = pokedex.getPokemonMetadata(0);
            assertNotNull(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPokemonMetadataWrongIntException() throws Exception {
        PokemonMetadata result = pokedex.getPokemonMetadata(-1);
        assertThrows(PokedexException.class, () -> {
        });
    }
    @Test
    void getPokemonMetadataNonExistException() throws Exception {
        PokemonMetadata result = pokedex.getPokemonMetadata(5000);
        assertThrows(PokedexException.class, () -> {
        });
    }
}