package racingcar.domain

import racingcar.MoveStrategy
import racingcar.RandomMoveStrategy

object CarFactory {
    fun createsCars(carNames: List<String>, moveStrategy: MoveStrategy = RandomMoveStrategy()): Cars {
        return Cars(carNames.map { Car(it) }, moveStrategy)
    }
}
