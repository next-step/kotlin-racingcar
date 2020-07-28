package step3.turn

import step3.racing.car.Car
import step3.racing.printer.CarPrinter
import step3.racing.rule.CarMovementRule

class TurnImpl(override val doEachTurn: () -> Unit) : Turn {
    override var current = 0

    companion object Factory {
        fun create(
            cars: List<Car>,
            rule: CarMovementRule,
            printer: CarPrinter
        ): Turn {
            return TurnImpl {
                cars.forEach {
                    rule.moveCarByRule(it)
                    printer.print(it)
                }
            }
        }
    }
}
