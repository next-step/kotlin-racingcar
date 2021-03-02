package racingcar

import racingcar.domain.PositiveCount
import racingcar.domain.RacingCarGame
import racingcar.userinterface.Console
import racingcar.userinterface.UserInterface

fun main() {
    val ui: UserInterface = Console()
    RacingCarApplication(ui).run()
}

class RacingCarApplication(private val userInterface: UserInterface) {

    fun run() {
        val carNames = listOf("pobi", "crong", "honux")

        val roundCountValue = userInterface.inputRoundCount()
        val roundCount = PositiveCount(roundCountValue)

        val racingCarGame = RacingCarGame(carNames, roundCount)
        racingCarGame.start()

        val results = racingCarGame.result()
        userInterface.outputResult(results)
    }
}
