package racingcar.domain.racing

import racingcar.domain.car.Car
import racingcar.domain.car.CarName

interface RacingCarGenerator {
    fun generate(name: CarName): Car
}
