package racingcar.ui

import jdk.internal.joptsimple.internal.Strings
import racingcar.Car
import racingcar.Cars

class ResultView {
    fun printCurrent(cars: Cars) {
        cars.cars.map {
            println(it.name + ":  " + createPositionBar(it))
        }
        println()
    }

    private fun createPositionBar(it: Car): String {
        var positionBar = Strings.EMPTY
        repeat(it.position) {
            positionBar += POSITION_DISPLAY_BAR
        }
        return positionBar
    }

    fun printWinner(winner: List<Car>) {
        println("우승자: " + winner.joinToString { it.name })
    }

    companion object {
        const val POSITION_DISPLAY_BAR: String = "-"
    }
}
