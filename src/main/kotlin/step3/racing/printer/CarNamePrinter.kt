package step3.racing.printer

import step3.racing.car.Car
import step3.racing.const.CAR_NAME_FORMAT
import step3.racing.const.UNDERBAR
import step3.racing.view.View

class CarNamePrinter(override val view: View) : CarPrinter {
    override fun printString(car: Car) = String.format(CAR_NAME_FORMAT, car.name, UNDERBAR.repeat(car.distance))
}
