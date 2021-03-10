package racingcar.ui

import racingcar.model.Car
import racingcar.util.Message.Companion.NOTICE_OUTPUT_WINNERS
import racingcar.util.Message.Companion.NOTICE_RESULT
import racingcar.util.Message.Companion.SEPARATOR_OUTPUT_WINNERS

object OutputView {
    fun getResult(isLast: Boolean = false, car: Car) {
        println("$car : ${car.whereIs()}")
        if (isLast) println()
    }

    fun noticeResult() {
        println(NOTICE_RESULT)
    }

    fun noticeWinners(findWinners: List<Car>) {
        println(
            findWinners.joinToString(
                separator = SEPARATOR_OUTPUT_WINNERS,
                transform = { i -> i.toString() }
            ).plus(NOTICE_OUTPUT_WINNERS)
        )
    }
}
