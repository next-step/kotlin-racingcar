package car.racing.view

import car.racing.domain.Car

class ResultView {

    fun show(cars: List<Car>, turnCount: Int) {
        println("실행결과")

        (1..turnCount).forEach { turn ->
            cars.forEach { car ->
                val moveDistance = car.getMoveDistanceUntilTurn(turn)
                println(moveDistance)
            }
            println()
        }
    }
}
