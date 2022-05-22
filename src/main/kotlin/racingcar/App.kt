package racingcar

import racingcar.view.Input
import racingcar.view.Output

fun main() {

    val racingGameController = RacingGameController(
        input = Input(),
        output = Output()
    )
    racingGameController.start()
}
