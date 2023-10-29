package racingcar

class RacingGame {
    fun play(cars: Array<Car>, tryMoveCount: Int, moveCondition: MoveCondition) {
        println("실행 결과")

        repeat(tryMoveCount) {
            playEachRound(cars, moveCondition)
            println()
        }
    }

    private fun playEachRound(cars: Array<Car>, moveCondition: MoveCondition) {
        cars.forEach { car ->
            car.tryMove(moveCondition)

            ResultView.printSkid(car.position)
        }
    }
}
