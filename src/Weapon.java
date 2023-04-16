public class Weapon {
    int price;
    int strength;
    int number = 1;

    Weapon(int price) {

        this.price = price;
        this.strength = price / 100;
    }
}