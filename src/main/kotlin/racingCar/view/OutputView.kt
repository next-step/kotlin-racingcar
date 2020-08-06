package racingCar.view

import racingCar.domain.Car

object OutputView {

    private const val TRACK_MARKER = "="
    private const val PARTICIPANT_NAME_DELIMITER = ":"

    fun getCarRacingResult(racingCarResult: List<Car>) {
        racingCarResult.forEach {
            println(it.name + PARTICIPANT_NAME_DELIMITER + makeRacingMap(it.distance))
        }
    }

    private fun makeRacingMap(distance: Int): String {
        return if (distance == 0) "" else TRACK_MARKER.repeat(distance)
    }

    fun getCarRacingWinners(racingWinnerResult: String) {
        println("최종 우승자는 $racingWinnerResult 입니다.")
    }
}
