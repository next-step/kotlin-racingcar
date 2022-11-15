package racingcar.domain.racing_game

import racingcar.model.Car

interface RacingGame {
    val cars: List<Car>
    fun race()
}
