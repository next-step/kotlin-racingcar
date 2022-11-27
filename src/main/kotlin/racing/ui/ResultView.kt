package racing.ui

import racing.domain.Cars

private const val DISPLAY_MARK = "-"
private const val DELIMITER = """:"""
private const val DELIMITER_OF_WINNERS = ", "
private const val MESSAGE_OF_WINNERS = "가 최종 우승했습니다."

object ResultView {

    fun printResult() {
        println("실행 결과")
    }

    fun print(cars: Cars) {
        cars.value().forEach { car ->
            println("${car.name()} $DELIMITER ${DISPLAY_MARK.repeat(car.position)}")
        }
        println()
    }

    fun printWinners(names: List<String>) {
        println("${names.joinToString(DELIMITER_OF_WINNERS)}$MESSAGE_OF_WINNERS")
    }
}
