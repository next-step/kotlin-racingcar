package racingcar

import racingcar.domain.RacingGame

fun main() {
    RacingGameApplication().run()
}

class RacingGameApplication(private val racingGame: RacingGame) {

    constructor() : this(racingGame = RacingGame())

    fun run() {
        racingGame.start()
    }
}
