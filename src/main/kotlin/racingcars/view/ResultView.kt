package racingcars.view

import racingcars.domain.Car

class ResultView {
    fun printRaceResults(racingCars: List<Car>) = printCurrentPosition(racingCars)

    private fun printCurrentPosition(racingCars: List<Car>) {
        racingCars.forEach { car ->
            val positionString = positionToString(car.position)
            println("${car.name} : $positionString")
        }
        println()
    }

    private fun positionToString(position: Int): String {
        return "-".repeat(position)
    }

    fun printWinners(winnersCar: List<Car>) {
        val winnerNames = winnersCar.joinToString(", ") { it.name }
        println(winnerNames + PRINT_WIN_MESSAGE)
    }

    companion object {
        private const val PRINT_WIN_MESSAGE = "이 최종 우승했습니다."
    }
}
