package racingcar.view

import racingcar.model.Cars
import racingcar.model.RacingCarGameResult

class ConsoleOutputView(
    private val carSymbol: String = DEFAULT_CAR_SYMBOL
) : OutputView {

    override fun showGameStart() {
        printDivider()
        println("자동차 경주를 시작합니다.")
    }

    override fun showGameRoundStart(round: Int, cars: Cars) {
        println("현재 라운드: $round")
    }

    override fun showGameRoundEnd(round: Int, cars: Cars) = printCarPositions(cars)

    override fun showGameResult(result: RacingCarGameResult) {
        println("자동차 경주를 종료합니다.")
        println("총 자동차 대수: ${result.cars.size}")
        println("총 시도한 횟수: ${result.gameCount}")
        printCarPositions(result.cars)
        printWinnerCars(result.cars)
        printDivider()
    }

    private fun printCarPositions(cars: Cars) {
        cars.forEach { car ->
            print("${car.carName} : ")
            printCarSymbols(car.position)
            println()
        }
        println()
    }

    private fun printCarSymbols(repeatTimes: Int) = repeat(repeatTimes) { print(carSymbol) }

    private fun printWinnerCars(cars: Cars) = cars
        .filterWinners()
        .joinToString { car -> car.carName.toString() }
        .let { winnerCars -> println("${winnerCars}가 최종 우승했습니다.") }

    private fun printDivider() = println("---------------------------------------------")

    companion object {
        private const val DEFAULT_CAR_SYMBOL = "-"
    }
}
