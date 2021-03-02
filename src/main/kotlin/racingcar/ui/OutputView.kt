package racingcar.ui

import racingcar.model.Car
import racingcar.util.Message.Companion.NOTICE_RESULT

object OutputView {
    fun getResult(isLast: Boolean, car: Car) {
        println(car.whereIs())
        if (isLast) println()
    }

    fun noticeResult() {
        println(NOTICE_RESULT)
    }
}
