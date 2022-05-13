package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {

    @Mock
    IPokemonMetadataProvider mockedMetadataProvider;

    PokemonMetadata metadata;

    Pokemon pokemon = new Pokemon(0,"Bulbizarre", 126,126,90,613,64,4000,4,56);

    @BeforeEach
    void setUp() {
        mockedMetadataProvider =mock(IPokemonMetadataProvider.class);
        metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    }

    @Test
    void createPokemon() {
        assertDoesNotThrow(() -> {
            when(mockedMetadataProvider.getPokemonMetadata(0)).thenReturn(metadata);
        });
        IPokemonFactory pokemonFactory = new PokemonFactory(mockedMetadataProvider);
        Pokemon resultPokemon = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(pokemon.getIndex(), resultPokemon.getIndex());
        assertEquals(pokemon.getCp(), resultPokemon.getCp());
        assertEquals(pokemon.getHp(), resultPokemon.getHp());
        assertEquals(pokemon.getCandy(), resultPokemon.getCandy());
        assertTrue(metadata.getAttack() <= resultPokemon.getAttack() && resultPokemon.getAttack() <= metadata.getAttack()+15);
        assertTrue(metadata.getDefense() <= resultPokemon.getDefense() && resultPokemon.getDefense() <= metadata.getDefense()+15);
        assertTrue(metadata.getStamina() <= resultPokemon.getStamina() && resultPokemon.getStamina() <= metadata.getStamina()+15);
        assertEquals( metadata.getAttack() + Math.round(15 * resultPokemon.getIv()), resultPokemon.getAttack() );
        assertEquals( metadata.getDefense() + Math.round(15 * resultPokemon.getIv()), resultPokemon.getDefense() );
        assertEquals( metadata.getStamina() + Math.round(15 * resultPokemon.getIv()), resultPokemon.getStamina() );
    }
}