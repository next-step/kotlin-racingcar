package racingcar.view

import racingcar.model.Car
import racingcar.model.RacingCarGameResult
import racingcar.model.RacingCarSnapshot

class ConsoleOutputView(
    private val carSymbol: String = DEFAULT_CAR_SYMBOL
) : OutputView {

    override fun showGameResult(result: RacingCarGameResult) {
        println("\n실행 결과")
        result.snapshots.forEach(::printSnapshot)
        printWinnerCars(result.winnerCars)
    }

    private fun printSnapshot(snapshot: RacingCarSnapshot) {
        snapshot.forEach { car ->
            print("${car.carName} : ")
            printCarSymbols(car.position)
            println()
        }
        println()
    }

    private fun printCarSymbols(repeatTimes: Int) = repeat(repeatTimes) { print(carSymbol) }

    private fun printWinnerCars(cars: List<Car>) = cars
        .joinToString { car -> car.carName.toString() }
        .let { winnerCars -> print("${winnerCars}가 최종 우승했습니다.") }

    companion object {
        private const val DEFAULT_CAR_SYMBOL = "-"
    }
}
