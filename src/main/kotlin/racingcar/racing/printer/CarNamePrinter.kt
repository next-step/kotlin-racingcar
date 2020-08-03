package racingcar.racing.printer

import racingcar.racing.car.Car
import racingcar.racing.const.CAR_NAME_FORMAT
import racingcar.racing.const.UNDER_BAR
import racingcar.racing.view.View

class CarNamePrinter(override val view: View) : CarPrinter {
    override fun printString(car: Car) = String.format(CAR_NAME_FORMAT, car.name, UNDER_BAR.repeat(car.distance))
}
