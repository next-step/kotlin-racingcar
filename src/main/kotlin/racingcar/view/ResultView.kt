package racingcar.view

import racingcar.constant.Constant
import racingcar.constant.Message
import racingcar.domain.dto.Record
import racingcar.util.Validation

object ResultView {
    private const val DISTANCE_CHARACTER = "-"

    private fun getDistanceOnScreen(distance: Int): String {
        var location = Constant.EMPTY
        repeat(distance) { location += DISTANCE_CHARACTER }
        return location
    }

    fun printRacingResult(record: Record) {
        record.roundResult.forEach { car ->
            println("${car.name}: ${getDistanceOnScreen(car.distance)}")
        }
        printEmptyView()
    }

    fun printRacingWinner(winnerList: List<String>) {
        print(String.format(Message.RESULT_WINNER, winnerList.joinToString(Validation.DELIMITER)))
    }

    private fun printEmptyView() {
        println()
    }
}
