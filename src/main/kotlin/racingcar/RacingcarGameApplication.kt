package racingcar

import racingcar.component.CarMovementManager
import racingcar.component.RacingcarGameContext

fun main() {
    val racingcarGameContext = RacingcarGameContext()
    val carMovementManager = CarMovementManager()

    val application = RacingcarGame(
        racingcarGameContext = racingcarGameContext,
        carMovementManager = carMovementManager
    )

    application.play()
}
