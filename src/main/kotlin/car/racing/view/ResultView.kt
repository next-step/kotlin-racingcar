package car.racing.view

import car.racing.domain.Car

class ResultView {

    fun show(cars: List<Car>, turnCount: Int) {
        println("실행결과")

        repeat(turnCount) { turn ->
            cars.forEach { car ->
                val moveDistance = car
                    .getMoveDistanceUntilTurn(turn)
                    .filter { it }
                    .joinToString(SEPARATOR) { "-" }

                println(moveDistance)
            }
            println()
        }
    }

    companion object {
        private const val SEPARATOR = ""
    }
}
