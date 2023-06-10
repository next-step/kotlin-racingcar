package racingcar.racing

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Input
import racingcar.util.NumberGenerator
import racingcar.util.RandomNumberGenerator

class Racing(
    private val input: Input,
    numberGenerator: NumberGenerator = RandomNumberGenerator(),
    private val printResult: (Cars) -> Unit = { }
) {
    private val cars: Cars = Cars(numberGenerator, input.carCount)
    fun start() {
        repeat(input.rounds) {
            runRound()
        }
    }

    fun runRound() {
        cars.moveAll()
        printResult(cars)
    }

    fun getCars(): Iterator<Car> = cars.iterator()
}
