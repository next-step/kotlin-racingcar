package racingcar.racing.printer

import racingcar.racing.car.Car
import racingcar.racing.const.CAR_NAME_FORMAT
import racingcar.racing.const.UNDERBAR
import racingcar.racing.view.View

class CarNamePrinter(override val view: View) : CarPrinter {
    override fun printString(car: Car) = String.format(CAR_NAME_FORMAT, car.name, UNDERBAR.repeat(car.distance))
}
