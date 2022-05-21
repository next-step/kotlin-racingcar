package racingcar.view

import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.RacingGameResult

class Output {

    fun showStartMessage() {
        println("----------------------------------")
        println("실행결과")
    }

    fun showResultPosition(cars: Cars) {
        cars.forEach {
            showName(it.name)
            showGauge(it.position)
        }
        println()
    }

    private fun showName(name: CarName) {
        print("$name : ")
    }

    private fun showGauge(position: Int) {
        repeat(position) {
            print("-")
        }
        println()
    }

    fun printWinners(racingGameResult: RacingGameResult) {
        println("---------------------------")
        showStartMessage()

        racingGameResult.result.forEach {
            showResultPosition(it.cars)
        }
        println("${showWinners(racingGameResult.winners)} 가 최종 우승했습니다.")
    }

    fun printWinners(cars: Cars) {
        println("${showWinners(cars)} 가 최종 우승했습니다.")
    }

    private fun showWinners(cars: Cars): String {
        return cars.findWinners()
            .getCarNameList().joinToString(COMMA_SEPARATOR)
    }

    companion object {
        private const val COMMA_SEPARATOR = ", "
    }
}
