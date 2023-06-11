package racingcar.controller

import racingcar.model.CarName
import racingcar.model.MoveStrategy
import racingcar.model.RacingCar
import racingcar.model.RacingCars
import racingcar.model.RacingReferee
import racingcar.model.RacingStadium
import racingcar.model.RandomMoveStrategy
import racingcar.view.inputCarNames
import racingcar.view.inputLabs
import racingcar.view.printResult
import racingcar.view.printWinners

fun main() {
    val moveStrategy: MoveStrategy = RandomMoveStrategy()
    val cars = RacingCars(inputCarNames.map { RacingCar(CarName(it), moveStrategy) })

    val history: Collection<RacingCars> = RacingStadium(inputLabs) racing cars
    printResult(history)
    printWinners(RacingReferee(history))
}
