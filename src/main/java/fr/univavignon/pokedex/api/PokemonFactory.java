package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        try {
            PokemonMetadata pokemonMetadata = metadataProvider.getPokemonMetadata(index);
            double iv = Math.random();
            return new Pokemon(
                    index,
                    pokemonMetadata.getName(),
                    (int) ( pokemonMetadata.getAttack() + pokemonMetadata.getAttack() * iv),
                    (int) (pokemonMetadata.getDefense() + pokemonMetadata.getDefense() * iv),
                    (int) (pokemonMetadata.getStamina() + pokemonMetadata.getStamina() * iv),
                    cp,
                    hp,
                    dust,
                    candy,
                    iv*100
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
