package racingCar.view

import racingCar.domain.Position
import racingCar.domain.Username
import racingCar.dto.ResultDto

object OutputView {

    private const val USERNAME_ASK_QST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val TRY_NUM_ASK_QST = "시도할 횟수는 몇 회인가요?"
    private const val RESULT_MSG = "실행결과"
    private const val POSITION_UNIT = "-"
    private const val WINNER_DESCRIPTION_MSG = "가 최종 우승했습니다."
    fun askTryNumber() = println(TRY_NUM_ASK_QST)
    fun askUsernames() = println(USERNAME_ASK_QST)
    fun printResultMsg() = println(RESULT_MSG)
    fun printResult(result: ResultDto) {
        println()
        result.positions.forEach {
            println("${it.key.username} : ${toPositionUnits(it.value)}")
        }
    }

    private fun toPositionUnits(position: Position): String {
        return (0..position.position)
            .map { POSITION_UNIT }
            .joinToString("")
    }

    fun printWinners(winners: List<Username>) {
        println("${winners.map { it.username }.joinToString(",")}${WINNER_DESCRIPTION_MSG} ")
    }
}
