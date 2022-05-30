package racingcar

import racingcar.domain.Car
import racingcar.domain.MoveStrategy
import racingcar.domain.Over4MoveStrategy
import racingcar.repository.CarRepository
import racingcar.service.RandomGenerator
import racingcar.view.response.GameResult

class RacingCarService(
    private val carRepository: CarRepository,
    private val randomGenerator: RandomGenerator,
    private val moveStrategy: MoveStrategy = Over4MoveStrategy(randomGenerator)
) {

    fun playGame(numberOfCars: Int, numberOfTries: Int): GameResult {
        val cars = initialize(numberOfCars)
        val gameResult = GameResult()

        if (numberOfTries < 1) {
            throw IllegalArgumentException("시도 횟수는 1번 이상이어야 합니다")
        }

        for (i in 1..numberOfTries) {
            cars.forEach {
                moveStrategy.move(it)
            }
            val repsResult = GameResult.RepsResult(cars.map { GameResult.CarSnapShot(it.id, it.position) })
            gameResult.addReps(repsResult)
        }

        return gameResult
    }

    private fun initialize(numberOfCars: Int): List<Car> {
        if (numberOfCars == 0) {
            throw IllegalArgumentException("자동차 대수는 2대 이상이어야 합니다.")
        }
        for (i in 1..numberOfCars) {
            val car = Car(i)
            carRepository.save(car)
        }
        return carRepository.findAll()
    }
}
