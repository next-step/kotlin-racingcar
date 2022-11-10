package study.step3

import study.step3.car.CarFactory
import study.step3.io.OutputView

class RacingGame(private val countOfCars: Int, private val countOfAttempts: Int) {
    fun run() {
        val randomNumberGenerator = RandomNumberGenerator(MAX_RANDOM_NUMBER)
        val racing = Racing(CarFactory.createCars(this.countOfCars), randomNumberGenerator)

        repeat((1..this.countOfAttempts).count()) {
            OutputView.showResult(racing.play())
        }
    }

    companion object {
        private const val MAX_RANDOM_NUMBER = 9
    }
}
