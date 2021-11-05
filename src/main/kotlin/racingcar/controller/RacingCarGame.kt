package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.printCurrentPosition
import racingcar.view.readCarNames
import racingcar.view.readNumberOfGames
import racingcar.view.showWinners

class RacingCarGame {
    fun start() {
        val carNames = readCarNames()
        val numberOfGames = readNumberOfGames()
        val cars = Cars(carNames, RandomNumberNumberGenerator())

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
}
