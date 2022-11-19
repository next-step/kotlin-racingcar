package racingCar.view

import racingCar.domain.Car
import racingCar.domain.Position
import racingCar.dto.ResultDto

object OutputView {

    private const val USERNAME_ASK_QST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val TRY_NUM_ASK_QST = "시도할 횟수는 몇 회인가요?"
    private const val RESULT_MSG = "실행결과"
    private const val POSITION_UNIT = "-"
    private const val WINNER_DESCRIPTION_MSG = "가 최종 우승했습니다."
    private const val CAR_NAME_SEPARATOR = ","
    fun askTryNumber() = println(TRY_NUM_ASK_QST)
    fun askUsernames() = println(USERNAME_ASK_QST)
    fun printResultMsg() = println(RESULT_MSG)
    fun printResult(result: ResultDto) {
        println()
        result.positions.forEach {
            println("${it.key.carName} : ${toPositionUnits(it.value)}")
        }
    }

    fun printWinners(winners: List<Car>) {
        println("${winners.joinToString(CAR_NAME_SEPARATOR) { getNameOfCar(it) }}  $WINNER_DESCRIPTION_MSG ")
    }

    private fun getNameOfCar(car: Car) = car.name.carName
    private fun toPositionUnits(position: Position): String {
        return (1..position.position)
            .joinToString("") { POSITION_UNIT }
    }
}
