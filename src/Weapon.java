public class Weapon {
    int price;
    int strength;

    Weapon(int price) {

        this.price = price;
        this.strength = price / 100;
    }
}
