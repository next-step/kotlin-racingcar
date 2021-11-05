package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.view.printCurrentPosition
import racingcar.view.readCarNames
import racingcar.view.readNumberOfGames
import racingcar.view.showWinners

const val MINIMUM_WINNER_COUNT = 1

fun main() {
    val carNames = readCarNames()
    val numberOfGames = readNumberOfGames()
    val cars = Cars(carNames)

    showInitialOutputs(cars)

    playGames(numberOfGames, cars)

    showWinners(cars.getWinners())
}

private fun showInitialOutputs(cars: Cars) {
    println("\n실행 결과")
    printCurrentPosition(cars.getCarsNameWithPosition())
    println()
}

private fun playGames(numberOfGames: Int, cars: Cars) {
    repeat(numberOfGames) {
        cars.move()
        printCurrentPosition(cars.getCarsNameWithPosition())
        println()
    }
}

fun validateWinnersCount(winners: List<Car>) {
    require(winners.count() >= MINIMUM_WINNER_COUNT) { "우승자는 ${MINIMUM_WINNER_COUNT}명 이상이어야 합니다." }
}
