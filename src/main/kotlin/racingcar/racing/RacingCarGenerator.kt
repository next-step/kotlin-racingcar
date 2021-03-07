package racingcar.racing

import racingcar.racing.car.Car
import racingcar.racing.car.CarName

interface RacingCarGenerator {
    fun generate(name: CarName): Car

    companion object {
        val STANDARD = StandardRacingCarGenerator()
    }
}
