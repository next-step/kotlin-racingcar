package racingcar

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Name
import racingcar.domain.RacingGame
import racingcar.view.inputCarNameValues
import racingcar.view.inputCountOfRace
import racingcar.view.printResult
import racingcar.view.printWinner

fun main() {
    val names = inputCarNameValues().map { Name(it) }

    val cars = Cars(names.map { Car(it) })
    val round = inputCountOfRace()

    val racingGame = RacingGame(round, cars)
    val result = racingGame.race()

    printResult(result)

    val winners = result.winners()
    printWinner(winners)
}
