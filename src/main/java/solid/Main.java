package solid;

import java.awt.*;

/**
 * Спроектировать абстрактный класс Car, у которого должны быть свойства:
 * марка, модель, цвет, тип кузова, число колёс, тип топлива, тип коробки передач, объем двигателя;
 * методы: движение, обслуживание переключение передач, включение фар, включение дворников
 *
 * Описать мойку
 *
 */
public class Main {
    public static void main(String[] args) {
        Harvester harvester = new Harvester("make", "model", Color.black);
        CarWash carWash = new CarWash();
        harvester.setCarWash(carWash);
        harvester.wash();
    }
}
