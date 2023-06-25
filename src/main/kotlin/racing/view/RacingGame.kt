package racing.view

import racing.constant.RacingGameConstant.JOIN_CAR_COUNT_QUESTION
import racing.constant.RacingGameConstant.TRY_GAME_COUNT_QUESTION
import racing.service.GameMachine

fun main() {
    val carCount = GameMachine.askCounting(JOIN_CAR_COUNT_QUESTION)
    val tryGameCount = GameMachine.askCounting(TRY_GAME_COUNT_QUESTION)

    GameMachine.printResult(carCount, tryGameCount)
}
