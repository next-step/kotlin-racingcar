package racingcar

import racingcar.component.CarMovementManager
import racingcar.component.Cars

fun main() {
    val cars = Cars()
    val carMovementManager = CarMovementManager()

    val application = RacingcarGame(
        cars = cars,
        carMovementManager = carMovementManager
    )

    application.play()
}
