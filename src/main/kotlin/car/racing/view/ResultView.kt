package car.racing.view

import car.racing.domain.Car

class ResultView {

    fun show(
        cars: List<Car>,
        turnCount: Int,
        winners: List<Car>,
    ) {
        println("실행결과")

        repeat(turnCount) { turn ->
            printEachTurn(cars, turn)
            println()
        }

        val winnersName = winners.joinToString { winner -> winner.name }

        println("$winnersName 가 최종 우승했습니다.")
    }

    private fun printEachTurn(
        cars: List<Car>,
        turn: Int,
    ) {
        cars.forEach { car ->
            val moveDistance = car
                .getMovesUntilTurn(turn)
                .filter { it }
                .joinToString(SEPARATOR) { "-" }

            println("${car.name} : $moveDistance")
        }
    }

    companion object {
        private const val SEPARATOR = ""
    }
}
