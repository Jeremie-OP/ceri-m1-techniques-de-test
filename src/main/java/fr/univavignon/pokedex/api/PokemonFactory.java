package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    IPokemonMetadataProvider metadataProvider;
    public PokemonFactory(IPokemonMetadataProvider metadataProvider){
        this.metadataProvider  = metadataProvider;
    }

    public PokemonFactory(){
        this.metadataProvider  = new PokemonMetadataProvider();
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(index);
            double iv = Math.random();
            return new Pokemon(
                    index,
                    pokemonMetadata.getName(),
                    (int) ( pokemonMetadata.getAttack() + Math.round(15 * iv)),
                    (int) ( pokemonMetadata.getDefense() + Math.round(15 * iv)),
                    (int) ( pokemonMetadata.getStamina() + Math.round(15 * iv)),
                    cp,
                    hp,
                    dust,
                    candy,
                    iv
                    );
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        return new Pokemon(0,"null",0,0,0,0,0,0,0,0);
    }
}
