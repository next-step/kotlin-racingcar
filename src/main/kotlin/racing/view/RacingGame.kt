package racing.view

import racing.service.GameMachine

const val JOIN_CAR_COUNT_QUESTION = "자동차 대수는 몇 대인가요?"
const val TRY_GAME_COUNT_QUESTION = "시도할 횟수는 몇 회인가요?"

fun main() {
    val carCount = GameMachine.askCounting(JOIN_CAR_COUNT_QUESTION)
    val tryGameCount = GameMachine.askCounting(TRY_GAME_COUNT_QUESTION)

    GameMachine.printResult(carCount, tryGameCount)
}
