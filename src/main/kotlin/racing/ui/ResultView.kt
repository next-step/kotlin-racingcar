package racing.ui

import racing.domain.Car

private const val DISPLAY_MARK = "-"
private const val DELIMITER = """:"""

object ResultView {

    fun printResult() {
        println("실행 결과")
    }

    fun print(positions: List<Car>) {
        positions.forEach { car ->
            println("${car.name()} $DELIMITER ${DISPLAY_MARK.repeat(car.position)}")
        }
        println()
    }
}
