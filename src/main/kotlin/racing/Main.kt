package racing

import racing.domain.RacingGame
import racing.io.Input
import racing.io.Output

fun main() {
    val carNames = Input.readCarNames()
    val tryCount = Input.readTryCount()

    val racingGame = RacingGame(carNames, tryCount)
    val result = racingGame.play()

    Output.resultMessage(result)
}
