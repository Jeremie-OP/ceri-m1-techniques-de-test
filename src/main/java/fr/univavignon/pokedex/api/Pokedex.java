package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    public int size() {
        return 0;
    }

    public int addPokemon(Pokemon pokemon) {
        return 0;
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        return null;
    }

    public List<Pokemon> getPokemons() {
        return null;
    }

    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return null;
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return null;
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return null;
    }
}
