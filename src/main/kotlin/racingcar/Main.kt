package racingcar

import racingcar.car.RandomMoveStrategy
import racingcar.game.RacingCarGame

fun main() {
    val racingGame = RacingCarGame(RandomMoveStrategy())
    racingGame.play()
}
