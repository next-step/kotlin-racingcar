package racingcar

import racingcar.domain.Car
import racingcar.domain.MoveStrategy
import racingcar.domain.Over4MoveStrategy
import racingcar.repository.CarRepository
import racingcar.service.RandomGenerator
import racingcar.view.response.CarSnapShot
import racingcar.view.response.GameResult
import racingcar.view.response.RepsResult

private fun List<Car>.play1Reps(moveStrategy: MoveStrategy): RepsResult {
    for (it in this) {
        moveStrategy.move(it)
    }
    return RepsResult(this.map { CarSnapShot(it.name, it.position) })
}

private fun List<Car>.getWinnerNames(): List<String> {
    val maxPosition = this.maxOfOrNull { it.position } ?: throw IllegalArgumentException("우승자가 존재하지 않습니다.")

    return this.filter { it.position == maxPosition }.map { it.name }
}

class RacingCarService(
    private val carRepository: CarRepository,
    private val randomGenerator: RandomGenerator,
    private val moveStrategy: MoveStrategy = Over4MoveStrategy(randomGenerator),
) {

    fun playGame(carNames: List<String>, numberOfTries: Int): GameResult {
        val cars = initialize(carNames)
        val gameResult = GameResult()

        require(numberOfTries >= 1) { "시도 횟수는 1번 이상이어야 합니다" }

        for (i in 1..numberOfTries) {
            val repsResult = cars.play1Reps(moveStrategy)
            gameResult.addReps(repsResult)
        }

        val winnerNames = cars.getWinnerNames()
        gameResult.addWinners(winnerNames)

        return gameResult
    }

    private fun initialize(carNames: List<String>): List<Car> {
        require(carNames.size >= 2) { "자동차 대수는 2대 이상이어야 합니다." }
        for (name in carNames) {
            val car = Car(name)
            carRepository.save(car)
        }

        return carRepository.findAll()
    }
}
