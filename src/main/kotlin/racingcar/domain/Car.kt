package racingcar.domain

import racingcar.domain.vo.CarAction
import racingcar.domain.vo.CarName
import racingcar.domain.vo.CarPosition

class Car(
    private val name: CarName,
    private var position: CarPosition,
) {
    fun moveOrStand(numberGenerator: NumberGenerator) {
        if (checkIsMovable(decideCarAction(numberGenerator))) {
            position = position.advance()
        }
    }

    private fun decideCarAction(numberGenerator: NumberGenerator): CarAction {
        return CarAction.generate(numberGenerator.generate())
    }

    private fun checkIsMovable(carAction: CarAction): Boolean {
        return carAction.isMove()
    }

    fun getNameValue(): String {
        return name.value
    }

    fun getPositionValue(): Int {
        return position.value
    }

    companion object {
        fun makeNewCar(name: String): Car {
            return Car(CarName(name), CarPosition.startPosition())
        }
    }
}
