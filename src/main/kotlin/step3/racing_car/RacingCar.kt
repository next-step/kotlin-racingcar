package step3.racing_car

import step3.racing_car.ui.InputView
import step3.racing_car.ui.ResultView

/**
 * 자동차 경주 (초간단 자동차 경주 게임)
 *
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 *
 * @author KimJungSik
 * @since 2023/10/28
 * */

object RacingCar {

    private val USERS_START_VALUE = 0
    private val RANDOM_RANGE = 0..9

    enum class MoveType(val condition: Int, val moveSpace: Int) {
        ADVANCE(4, 1), STAY(0, 0)
    }

    /**
     * RacingCar 게임 시작
     * */
    fun run() {
        val inputView = InputView()

        inputView.draw(InputView.InputType.CAR)
        val numberCars = readln()
        errorCheck(numberCars)

        inputView.draw(InputView.InputType.ROUND)
        val roundCnt = readln()
        errorCheck(roundCnt)

        var carsCurrentPositionList: List<List<Int>> = List(numberCars.toInt()) { listOf(USERS_START_VALUE) }

        val resultView = ResultView()
        resultView.drawRacingResultMsg()

        repeat(roundCnt.toInt()) {
            carsCurrentPositionList = playRound(carsCurrentPositionList)
            resultView.drawRacingResult(carsCurrentPositionList.map { it.last() })
        }
    }

    fun errorCheck(inputStr: String?) {
        require(inputStr?.isNotEmpty() == true && Int.MAX_VALUE.toString().length >= inputStr.length && inputStr.toIntOrNull() != null && Int.MAX_VALUE > inputStr.toInt()) {
            "Invalid Expression: $inputStr"
        }
    }

    fun playRound(carsCurrentPositionList: List<List<Int>>): List<List<Int>> {
        return carsCurrentPositionList.map { positionList ->
            if (isAdvance(RANDOM_RANGE.random())) {
                positionList + listOf(positionList.last() + MoveType.ADVANCE.moveSpace)
            } else {
                positionList + listOf(positionList.last() + MoveType.STAY.moveSpace)
            }
        }
    }

    fun isAdvance(value: Int): Boolean = value >= MoveType.ADVANCE.condition
}