package racingcar

import racingcar.domain.Car
import racingcar.domain.MoveStrategy
import racingcar.domain.Over4MoveStrategy
import racingcar.repository.CarRepository
import racingcar.service.RandomGenerator
import racingcar.view.response.GameResult

fun List<Car>.play1Reps(moveStrategy: MoveStrategy, gameResult: GameResult): GameResult.RepsResult {
    for (it in this) {
        moveStrategy.move(it)
    }
    return GameResult.RepsResult(this.map { GameResult.CarSnapShot(it.id, it.position) })

}

class RacingCarService(
    private val carRepository: CarRepository,
    private val randomGenerator: RandomGenerator,
    private val moveStrategy: MoveStrategy = Over4MoveStrategy(randomGenerator)
) {

    fun playGame(numberOfCars: Int, numberOfTries: Int): GameResult {
        val cars = initialize(numberOfCars)
        val gameResult = GameResult()

        require(numberOfTries < 1) { "시도 횟수는 1번 이상이어야 합니다" }

        for (i in 1..numberOfTries) {
            val repsResult = cars.play1Reps(moveStrategy, gameResult)
            gameResult.addReps(repsResult)
        }

        return gameResult
    }

    private fun initialize(numberOfCars: Int): List<Car> {
        require(numberOfCars < 2) { "자동차 대수는 2대 이상이어야 합니다." }
        repeat(numberOfCars) {
            val car = Car(it)
            carRepository.save(car)
        }

        return carRepository.findAll()
    }
}
