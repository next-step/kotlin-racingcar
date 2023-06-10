package step3.workflow

import step3.entity.RacingCar

class Race(
    private val condition: () -> Boolean
) {
    operator fun invoke(racingCar: RacingCar): RacingCar =
        if (condition().not()) {
            RacingCar(racingCar.position)
        } else {
            RacingCar(racingCar.position + 1)
        }
}
