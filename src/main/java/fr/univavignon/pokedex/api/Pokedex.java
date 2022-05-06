package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
    private final List<Pokemon> pokemons = new ArrayList<>();
    final private IPokemonFactory pokemonFactory;
    final private IPokemonMetadataProvider pokemonMetadataProvider;

    public Pokedex(IPokemonFactory pokemonFactory, IPokemonMetadataProvider pokemonMetadataProvider){
        this.pokemonFactory = pokemonFactory;
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }
    public int size() {
        return pokemons.size();
    }

    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size()-1;
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            return pokemons.get(id);
        } catch (Exception e) {
            throw new PokedexException("pas de pokemon pour cet id");
        }
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return null;
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index,cp,hp,dust,candy);
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }
}
