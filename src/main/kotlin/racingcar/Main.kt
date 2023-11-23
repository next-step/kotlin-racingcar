package racingcar

import racingcar.controller.RacingController
import racingcar.domain.RacingGame

fun main() {
    val racingController = RacingController(
        RacingGame(DependencyConfig.moveStrategy),
        DependencyConfig.carInputProvider,
        DependencyConfig.outputProvider,
    )

    racingController.startRace()
}
