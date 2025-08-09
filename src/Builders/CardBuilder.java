package Builders;

public interface CardBuilder<Card> {
    CardBuilder<Card> withName(String name);
    CardBuilder<Card> withNationality(String nationality);
    Card build();
}
