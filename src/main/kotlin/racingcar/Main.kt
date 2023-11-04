package racingcar

import racingcar.domain.RacingPlayers
import racingcar.domain.RacingStadium
import racingcar.domain.RandomRacingRule
import racingcar.util.Message
import racingcar.view.ResultView
import racingcar.view.View

object Racing {
    const val RANDOM_START = 0
    const val RANDOM_END = 9
    const val MOVE_FORWARD_CONDITION = 4
}

fun main() {
    val nameOfCars = View.printAndGetLine(Message.NAME_OF_CARS_INPUT, Message.INPUT_EXCEPTION)
    val numberOfTrials = View.printAndGetLineToInt(Message.NUMBER_OF_TRIALS_INPUT, Message.INPUT_NUMBER_EXCEPTION)

    RacingStadium(
        RacingPlayers.of(nameOfCars),
        RandomRacingRule()
    ).gameStart(numberOfTrials).also {
        ResultView.racingResultPrint(it)
    }
}
