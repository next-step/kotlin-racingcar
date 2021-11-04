package racingcar.controller

import racingcar.domain.ATTEMPT_NUMBER_RANGE
import racingcar.domain.Car
import racingcar.view.printCurrentPosition
import racingcar.view.readCarNames
import racingcar.view.readNumberOfGames
import racingcar.view.showWinners

const val MINIMUM_WINNER_COUNT = 1

fun main() {
    val carNames = readCarNames()
    val numberOfGames = readNumberOfGames()

    val carList: MutableList<Car> = mutableListOf()

    println("\n실행 결과")

    carNames.forEach { carName -> initCarList(carName, carList) }

    println()

    repeat(numberOfGames) { playGame(carList) }

    val winners = getWinners(carList)

    showWinners(winners)
}

private fun initCarList(carName: String, carList: MutableList<Car>) {
    val car = Car(carName)
    carList.add(car)
    printCurrentPosition(car.name, car.position)
}

private fun playGame(carList: MutableList<Car>) {
    carList.forEach {
        it.move(ATTEMPT_NUMBER_RANGE.random())
        printCurrentPosition(it.name, it.position)
    }
    println()
}

private fun getWinners(carList: MutableList<Car>): List<String> {
    val winnerPosition = carList.maxOf { it.position }
    val winners = carList.filter { it.position == winnerPosition }
    validateWinnersCount(winners)
    return winners.map { it.name }
}

fun validateWinnersCount(winners: List<Car>) {
    require(winners.count() >= MINIMUM_WINNER_COUNT) { "우승자는 ${MINIMUM_WINNER_COUNT}명 이상이어야 합니다." }
}
