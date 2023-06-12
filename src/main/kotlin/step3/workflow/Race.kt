package step3.workflow

import step3.entity.RacingCar

class Race(
    private val condition: () -> Boolean,
) {
    operator fun invoke(cars: List<RacingCar>): List<RacingCar> =
        cars.map { race(it) }

    private fun race(racingCar: RacingCar): RacingCar =
        if (condition().not()) {
            RacingCar(name = racingCar.name, position = racingCar.position)
        } else {
            RacingCar(name = racingCar.name, position = racingCar.position + 1)
        }
}
