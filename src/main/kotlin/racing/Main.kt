package racing

import racing.domain.RacingGame
import racing.io.Input
import racing.io.Output

fun main() {
    val carCount = Input.readCarCount()
    val tryCount = Input.readTryCount()

    val racingGame = RacingGame(carCount, tryCount)
    val result = racingGame.play()

    Output.resultMessage(result)
}
