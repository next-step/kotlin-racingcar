package racingcar.controller

import racingcar.model.MoveStrategy
import racingcar.model.RacingCar
import racingcar.model.RacingStadium
import racingcar.model.RandomMoveStrategy
import racingcar.view.inputCarsCount
import racingcar.view.inputLabs
import racingcar.view.printResult

fun main() {
    val moveStrategy: MoveStrategy = RandomMoveStrategy()
    val cars: Collection<RacingCar> = (0 until inputCarsCount).map { RacingCar(moveStrategy) }
    printResult(RacingStadium(inputLabs) racing cars)
}
