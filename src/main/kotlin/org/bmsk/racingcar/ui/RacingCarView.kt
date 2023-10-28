package org.bmsk.racingcar.ui

import org.bmsk.racingcar.ui.input.RacingCarInputView
import org.bmsk.racingcar.ui.result.RacingCarResultView
import org.bmsk.racingcar.ui.string.CarShape
import kotlin.properties.Delegates

class RacingCarView(
    private val racingCarResultView: RacingCarResultView = RacingCarResultView(),
    private val racingCarInputView: RacingCarInputView = RacingCarInputView(),
) {
    private var numberOfAttempts by Delegates.notNull<Int>()

    fun run() {
        initRoad()
        println()
        printExecutionResults()
    }

    private fun initNumberOfCars() {
        println("자동차 대수는 몇 대인가요?")
        racingCarInputView.inputNumberOfCars().let { numberOfCars ->
            racingCarResultView.initRacingCarRoad(numberOfCars)
        }
    }

    private fun initNumberOfAttempts() {
        println("시도할 횟수는 몇 회인가요?")
        numberOfAttempts = racingCarInputView.inputNumberOfAttempts()
    }

    private fun initRoad() {
        initNumberOfCars()
        initNumberOfAttempts()
    }

    private fun printExecutionResults() {
        println("실행 결과")
        racingCarResultView.getCarRaceResult(numberOfAttempts).forEach { racingCarRoad ->
            racingCarRoad.cars.forEach { car ->
                repeat(car.position.xPos) {
                    print(CarShape.BAR_SHAPE)
                }
                println()
            }
            println()
        }
    }
}
