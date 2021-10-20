package car.racing.view

import car.racing.domain.Car
import car.racing.usecase.FindRaceWinner

class ResultView(
    private val findRaceWinner: FindRaceWinner,
) {

    fun show(cars: List<Car>, turnCount: Int) {
        println("실행결과")

        repeat(turnCount) { turn ->
            printEachTurn(cars, turn)
            println()
        }

        val winners = findRaceWinner.findByCars(cars, turnCount)
            .joinToString { winner -> winner.name }

        println("$winners 가 최종 우승했습니다.")
    }

    private fun printEachTurn(
        cars: List<Car>,
        turn: Int,
    ) {
        cars.forEach { car ->
            val moveDistance = car
                .getMoveDistanceUntilTurn(turn)
                .filter { it }
                .joinToString(SEPARATOR) { "-" }

            println("${car.name} : $moveDistance")
        }
    }

    companion object {
        private const val SEPARATOR = ""
    }
}
