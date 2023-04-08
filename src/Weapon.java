public class Weapon {

    String number;//tedad
    int price;
    int strength;

    Weapon(String number, int price) {

        this.number = number;
        this.price = price;
        this.strength = price / 100;
    }


}
