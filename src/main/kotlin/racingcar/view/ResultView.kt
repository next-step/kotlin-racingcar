package racingcar.view

import racingcar.domain.RacingCar
import racingcar.domain.RacingCars

object ResultView {
    private const val PROGRESS_STRING = "-"

    fun showRacingStage(racingCars: RacingCars) {
        racingCars.list.forEach {
            showProgress(it)
        }
        println()
    }

    private fun showProgress(racingCar: RacingCar) {

        println("${racingCar.driver} : ${PROGRESS_STRING.repeat(racingCar.progress)}")
    }
}
