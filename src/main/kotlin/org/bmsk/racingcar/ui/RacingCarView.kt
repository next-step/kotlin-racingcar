package org.bmsk.racingcar.ui

import org.bmsk.effectivekotlin.domain.model.RacingCarRoad
import org.bmsk.effectivekotlin.model.CarShape
import org.bmsk.racingcar.ui.input.RacingCarInputView
import org.bmsk.racingcar.ui.result.RacingCarResultView
import kotlin.properties.Delegates

class RacingCarView(
    private val resultView: RacingCarResultView = RacingCarResultView(),
    private val inputView: RacingCarInputView = RacingCarInputView(),
) {
    private var numberOfAttempts by Delegates.notNull<Int>()

    fun run() {
        initializeCarNames()
        initializeNumberOfAttempts()
        println()
        displayExecutionResults()
    }

    private fun initializeCarNames() {
        println(ENTER_CAR_NAME_MESSAGE)
        inputView.inputNamesOfCars().let {
            resultView.initRacingCarRoad(it.size, it)
        }
    }

    private fun initializeNumberOfAttempts() {
        println(ASK_TRY_COUNT_MESSAGE)
        numberOfAttempts = inputView.inputNumberOfAttempts()
    }

    private fun displayExecutionResults() {
        println(RESULT_MESSAGE)
        val racingResult = resultView.getCarRacingRoadsResult(numberOfAttempts)
        displayRacingRoads(racingResult)
        displayWinners(racingResult.last())
    }

    private fun displayRacingRoads(racingResult: List<RacingCarRoad>) {
        racingResult.forEach { road ->
            road.cars.forEach { car ->
                println("${car.name} : ${CarShape.BAR_SHAPE.symbol.repeat(car.position.xPos)}")
            }
            println()
        }
    }

    private fun displayWinners(racingCarRoad: RacingCarRoad) {
        val winners = resultView.getCarRacingResultWinners(racingCarRoad).winnerNames
        println("${winners.joinToString(separator = ", ")}$WINNING_MESSAGE")
    }

    companion object {
        private const val ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ASK_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val RESULT_MESSAGE = "실행 결과"
        private const val WINNING_MESSAGE = "가 최종 우승했습니다."
    }
}
