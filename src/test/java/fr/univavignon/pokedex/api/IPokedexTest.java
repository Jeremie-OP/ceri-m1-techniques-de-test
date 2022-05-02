package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokedexTest {

    private IPokedex pokedex;

    private Pokemon pokemon0;
    private Pokemon pokemon133;

    @BeforeEach
    void setUp() {
        pokedex = new Pokedex();
        pokemon0 = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemon133 = new Pokemon(133,"Aquali", 186,168,260,2729,202,5000,4,100);
        when(pokemon0.getIndex()).thenReturn(0);
        when(pokemon133.getIndex()).thenReturn(133);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void size() {
        int result = pokedex.size();
        pokedex.addPokemon(pokemon0);
        assertEquals(result + 1, pokedex.size());
    }

    @Test
    void addPokemon() {
        int result = pokedex.addPokemon(pokemon0);
        assertEquals(pokemon0.getIndex(), result);
        result = pokedex.addPokemon(pokemon133);
        assertEquals(pokemon133.getIndex(), result);
    }

    @Test
    void getPokemon() throws Exception {
        Pokemon result = pokedex.getPokemon(133);
        assertEquals(pokemon133, result);
    }

    @Test
    void getPokemonExceptionTest() throws Exception{
        pokedex.getPokemon(-1);
        assertThrows(PokedexException.class, () -> {

        });
    }

    @Test
    void getPokemons() {

    }

}