package racingcar

class RacingGame {
    fun play() {
        val carCount = InputView.getCarCount()
        val tryMoveCount = InputView.getTryMoveCount()

        val cars = Array(carCount) { Car() }

        println("실행 결과")

        repeat(tryMoveCount) {
            playEachRound(cars)
            println()
        }
    }

    private fun playEachRound(cars: Array<Car>) {
        cars.forEach { car ->
            val random = (0..10).random()

            car.tryMove(MinimumAboveNumberMoveCondition { random })

            ResultView.printSkid(car.position)
        }
    }
}
