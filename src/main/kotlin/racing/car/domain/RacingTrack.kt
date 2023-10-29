package racing.car.domain

import racing.car.util.RandomGenerator
import racing.car.util.RandomNumberGenerator
import racing.car.view.ResultView

class RacingTrack(
    private val randomGenerator: RandomGenerator = RandomNumberGenerator(),
) {
    fun race(racingCars: List<Car>, numberOfRounds: Int) {
        repeat(numberOfRounds) {
            racingCars.forEach { it.move(randomGenerator.generate()) }
            ResultView.printResult(racingCars)
        }
    }
}
