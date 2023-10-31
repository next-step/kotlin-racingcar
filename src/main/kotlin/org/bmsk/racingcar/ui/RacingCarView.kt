package org.bmsk.racingcar.ui

import org.bmsk.racingcar.model.CarShape.BAR_SHAPE
import org.bmsk.racingcar.ui.input.RacingCarInputView
import org.bmsk.racingcar.ui.result.RacingCarResultView
import org.bmsk.racingcar.ui.string.GuideMessage
import kotlin.properties.Delegates

class RacingCarView(
    private val racingCarResultView: RacingCarResultView = RacingCarResultView(),
    private val racingCarInputView: RacingCarInputView = RacingCarInputView(),
) {
    private var numberOfAttempts by Delegates.notNull<Int>()

    fun run() {
        initNumberOfCars()
        initNumberOfAttempts()
        println()
        printExecutionResults()
    }

    private fun initNumberOfCars() {
        println(GuideMessage.ASK_CAR_COUNT)
        racingCarInputView.inputNumberOfCars().let { numberOfCars ->
            racingCarResultView.initRacingCarRoad(numberOfCars)
        }
    }

    private fun initNumberOfAttempts() {
        println(GuideMessage.ASK_TRY_COUNT)
        numberOfAttempts = racingCarInputView.inputNumberOfAttempts()
    }

    private fun printExecutionResults() {
        println(GuideMessage.RESULT)
        racingCarResultView.getCarRaceResult(numberOfAttempts).forEach { racingCarRoad ->
            racingCarRoad.cars.forEach { car ->
                repeat(car.position.xPos) { print(BAR_SHAPE.symbol) }
                println()
            }
            println()
        }
    }
}
