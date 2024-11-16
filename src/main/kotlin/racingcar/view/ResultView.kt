package racingcar.view

import racingcar.model.RacingCar

object ResultView {
    private const val FORWARD_STATUS = "-"
    private const val SHOW_RACING_START_MESSAGE = "실행 결과"

    fun showRacingStart() {
        println()
        println(SHOW_RACING_START_MESSAGE)
    }

    fun showRacingResult(forwardStatus: List<RacingCar>) {
        forwardStatus.forEach { car ->
            println(car.toString())
        }
        println()
    }
}
