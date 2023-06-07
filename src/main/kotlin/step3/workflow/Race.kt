package step3.workflow

import step3.entity.RacingCar
import kotlin.random.Random

class Race {
    operator fun invoke(racingCar: RacingCar): RacingCar =
        if (Random.nextInt(0, 10) <= 4) {
            RacingCar(racingCar.position)
        } else {
            RacingCar(racingCar.position + 1)
        }
}
