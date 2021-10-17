package car.racing.view

import car.racing.domain.Car

class ResultView {

    fun show(cars: List<Car>, turnCount: Int) {
        println("실행결과")

        (0 until turnCount).forEach { turn ->
            cars.forEach { car ->
                val moveDistance = car.getMoveDistanceUntilTurn(turn)
                println(moveDistance)
            }
            println()
        }
    }
}
