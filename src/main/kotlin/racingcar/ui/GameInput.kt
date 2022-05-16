package racingcar.ui

import racingcar.car.Car
import racingcar.car.RacingCar
import racingcar.engine.RandomEngine

data class GameInput(private val nameInput: String, val round: Int) {

    fun toRacingCars(): List<Car> {
        require(round > 0) { "round 는 1 이상이어야 합니다" }

        val names = nameInput.split(',').filter { it.isNotBlank() }

        require(names.isNotEmpty()) { "자동차는 1대 이상이어야 합니다" }
        require(names.all { it.length <= MAXIMUM_CAR_NAME_LENGTH }) { "자동차 이름은 ${MAXIMUM_CAR_NAME_LENGTH}자를 넘을 수 없습니다" }

        return names.map { RacingCar(RandomEngine(), it) }
    }

    companion object {
        private const val MAXIMUM_CAR_NAME_LENGTH = 5
    }
}
