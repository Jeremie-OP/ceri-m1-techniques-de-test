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

    Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);

    @BeforeEach
    void setUp() {
        pokemonFactory = new PokemonFactory();

    }

    @Test
    void createPokemon() {
        Pokemon resultPokemon = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(pokemon.getIndex(), resultPokemon.getIndex());
        assertEquals(pokemon.getCp(), resultPokemon.getCp());
        assertEquals(pokemon.getHp(), resultPokemon.getHp());
        assertEquals(pokemon.getCandy(), resultPokemon.getCandy());
    }
}