package racingcar.fixture

import racingcar.domain.RacingCars

class RacingCarsFixture {

    companion object {
        val RACING_CARS = RacingCars(listOf(RacingCarFixture.MOVABLE_RACING_CAR, RacingCarFixture.IMMOVABLE_RACING_CAR))
    }
}
