public class Weapon {
    int price;
    int strength;
    int number;

    Weapon(int price) {

        this.price = price;
        this.strength = price / 100;
    }
}