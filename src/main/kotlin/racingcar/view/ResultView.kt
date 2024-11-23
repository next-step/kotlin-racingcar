package racingcar.view

import racingcar.dto.RacingCarDto

object ResultView {
    private const val SHOW_RACING_START_MESSAGE = "실행 결과"
    private const val FORWARD_STATUS = "-"

    fun showRacingStart() {
        println()
        println(SHOW_RACING_START_MESSAGE)
    }

    fun showRacingResult(racingCarDtos: List<RacingCarDto>) {
        racingCarDtos.forEach { dto ->
            println("${dto.racingCarName}: ${FORWARD_STATUS.repeat(dto.position)}")
        }
        println()
    }

    fun showWinner(winners: List<String>) {
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
