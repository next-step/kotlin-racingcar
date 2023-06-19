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

    fun showWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }
    private fun showProgress(racingCar: RacingCar) {

        println("${racingCar.driver} : ${PROGRESS_STRING.repeat(racingCar.progress)}")
    }
}
