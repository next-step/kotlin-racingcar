package racingcar

import java.util.UUID
import kotlin.random.Random

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
            val seed = UUID.randomUUID().hashCode()
            val random = Random(seed).nextInt(10)

            car.tryMove(random)

            ResultView.printSkid(car.position)
        }
    }
}
