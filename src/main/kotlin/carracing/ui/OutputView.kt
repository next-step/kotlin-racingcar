package carracing.ui

import carracing.domain.CarsFactory
import carracing.domain.Racing

const val CAR_SYMBOL = "-"

object OutputView {

    fun gameRoundPrint(position: Int) {
        println(CAR_SYMBOL.repeat(position))
    }

    fun racingResult(carCount: Int, attemptCount: Int) {
        println("실행 결과")
        Racing(CarsFactory.of(carCount), attemptCount).race()
    }

    fun lineChange() {
        println("")
    }
}
