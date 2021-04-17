package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.movestrategy.RandomMoveStrategy
import racingcar.view.inputCarNameValues
import racingcar.view.inputCountOfRace
import racingcar.view.printResult

fun main() {
    val cars = Cars(inputCarNameValues().map { Car(it) })

    val round = inputCountOfRace()

    val racingGame = RacingGame(round, cars)
    val result = racingGame.race(RandomMoveStrategy())

    val winners = result.winners()

    printResult(result, winners)
}
