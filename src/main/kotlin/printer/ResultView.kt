package printer

import racingcar.Reception
import racingcar.Winners

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printWinners(winners: Winners) {
        print(winners.joinToWinners(Reception.CAR_NAME_DELIMITERS) + "가 최종 우승했습니다")
    }

    fun printRacing(carNames: List<String>, carPositions: List<List<Int>>) {
        carPositions.map { carPosition ->
            printCarsPath(carNames, carPosition)
            println()
        }
    }

    private fun printCarsPath(carNames: List<String>, positions: List<Int>) {
        positions.mapIndexed { index, position ->
            printName(carNames[index])
            printCarPath(position)
        }
    }

    private fun printCarPath(position: Int) {
        println("-".repeat(position))
    }

    private fun printName(name: String) {
        print("$name : ")
    }
}
