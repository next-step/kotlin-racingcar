package racingcar.view

import racingcar.domain.RacingCar

object ResultView {

    private const val CAR_POSITION_INDICATOR = "-"
    private const val RESULT_TITLE = "실행 결과"

    fun writeResultTitle() {
        println(RESULT_TITLE)
    }

    fun writeCarPosition(cars: List<RacingCar>) {
        cars.forEach { println(CAR_POSITION_INDICATOR.repeat(it.position.value)) }
        println()
    }
}
