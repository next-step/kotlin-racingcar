package racingcar

import racingcar.controller.RacingGameController
import racingcar.domain.strategy.RandomMoveStrategy

fun main() {
    RacingGameController.play(RandomMoveStrategy())
}
