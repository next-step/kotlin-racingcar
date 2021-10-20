package car.racing.view

import car.racing.domain.Car

class ResultView {

    fun show(cars: List<Car>, turnCount: Int) {
        println("실행결과")

        repeat(turnCount) { turn ->
            printEachTurn(cars, turn)
            println()
        }

        val winners = getWinners(cars, turnCount).joinToString(",")
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

    private fun getWinners(
        cars: List<Car>,
        turnCount: Int,
    ): List<String> {
        val turn = turnCount - 1
        val maxMoveDistance = cars
            .map { car -> car.getMoveDistanceUntilTurn(turn).filter { it }.size }
            .maxOrNull() ?: 0

        return cars.filter { car ->
            val moveDistance = car.getMoveDistanceUntilTurn(turn).filter { it }.size
            moveDistance == maxMoveDistance
        }.map { car -> car.name }
    }

    companion object {
        private const val SEPARATOR = ""
    }
}
