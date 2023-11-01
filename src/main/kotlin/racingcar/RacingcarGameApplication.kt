package racingcar

import racingcar.component.CarMovementManager
import racingcar.component.RacingcarGameManager

fun main() {
    val racingcarGameManager = RacingcarGameManager()
    val carMovementManager = CarMovementManager()

    val application = RacingcarGame(
        racingcarGameManager = racingcarGameManager,
        carMovementManager = carMovementManager
    )

    application.play()
}
