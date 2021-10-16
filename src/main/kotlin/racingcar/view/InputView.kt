package racingcar.view

import racingcar.exception.Exception
import racingcar.exception.Exception.Companion.CASE_INPUT_DATA_NOT_INT
import racingcar.model.RaceCondition

/**
 * 자동차 경주에서 게임 시작시 사용자가 입력해야하는 질문 모음 class
 * */
class InputView {
    fun inputRaceCondition(): RaceCondition {
        val carCount = requestNumberOfCar()
        val tryCount = requestTryCount()
        require(carCount > 0 && tryCount > 0) { Exception.CASE_INPUT_DATA_WRONG }
        return RaceCondition(carCount, tryCount)
    }

    private fun requestNumberOfCar(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!.toIntOrNull() ?: throw IllegalArgumentException(CASE_INPUT_DATA_NOT_INT)
    }

    private fun requestTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toIntOrNull() ?: throw IllegalArgumentException(CASE_INPUT_DATA_NOT_INT)
    }
}
