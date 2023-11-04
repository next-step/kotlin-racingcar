package racingcar

import racingcar.component.CarMovementManager

fun main() {
    val carMovementManager = CarMovementManager()

    val application = RacingcarGame(
        carMovementManager = carMovementManager
    )

    application.play()
}
