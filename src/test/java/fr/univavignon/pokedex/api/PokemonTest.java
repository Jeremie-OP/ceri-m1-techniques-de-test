package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    private Pokemon pokemon;

    @BeforeEach
    void setUp() {
        pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);
    }

    @Test
    void getCp() {
        assertEquals(613, pokemon.getCp());
    }

    @Test
    void getHp() {
        assertEquals(64, pokemon.getHp());
    }

    @Test
    void getDust() {
        assertEquals(4000, pokemon.getDust());
    }

    @Test
    void getCandy() {
        assertEquals(4, pokemon.getCandy());
    }

    @Test
    void getIv() {
        assertEquals(56, pokemon.getIv());
    }
}