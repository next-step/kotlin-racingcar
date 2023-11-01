package racingcar.domain.configuration

import racingcar.domain.car.Car
import racingcar.domain.car.CarGenerator
import racingcar.domain.car.CarName
import racingcar.domain.game.RoundCount
import racingcar.domain.rule.MoveRule
import racingcar.domain.rule.RandomMoveRule

class CarRacingConfiguration private constructor(
    val roundCount: RoundCount,
    val cars: List<Car>,
    val moveRule: MoveRule,
) {
    companion object {
        fun of(
            roundCount: Int,
            carNames: List<String>,
            moveRule: MoveRule = RandomMoveRule(),
        ): CarRacingConfiguration {
            require(carNames.isNotEmpty()) { "자동차 수는 0보다 커야 합니다" }

            return CarRacingConfiguration(
                cars = createCars(carNames),
                roundCount = RoundCount(roundCount),
                moveRule = moveRule,
            )
        }

        private fun createCars(carNames: List<String>): List<Car> = CarGenerator.create(carNames.map { CarName(it) })
    }
}
