package racingcar.view

import racingcar.domain.Car

object ResultView {
    private const val TEXT_RACING_RESULT = "실행 결과"
    private const val TEXT_NOTIFY_WINNER = "이(가) 최종 우승했습니다 !!!"
    private const val DISTANCE_MARK = "-"

    fun showResultTitle() = "\n$TEXT_RACING_RESULT".also(::println)

    fun showRace(carsOnTrack: List<Car>) {
        carsOnTrack.forEach { eachCar ->
            "${eachCar.name}: ${DISTANCE_MARK.repeat(eachCar.distance)}".also(::println)
        }
        println()
    }

    fun showWinner(winners: List<String>) {
        winners.filter { it != winners.last() }.forEach { winner ->
            "${winner}, ".also(::print)
        }
        "${winners.last()}${TEXT_NOTIFY_WINNER}".also(::print)
    }
}
