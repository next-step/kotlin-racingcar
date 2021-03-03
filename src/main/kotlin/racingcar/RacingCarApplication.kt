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
        val carNames = userInterface.inputCarNames()
        carNames.forEach { require(it.isNotBlank()) { "자동차 이름은 공백이 될 수 없습니다" } }

        val roundCountValue = userInterface.inputRoundCount()
        val roundCount = PositiveCount(roundCountValue)

        val racingCarGame = RacingCarGame(carNames, roundCount)
        racingCarGame.start()

        val results = racingCarGame.result()
        userInterface.outputResult(results)
    }
}
