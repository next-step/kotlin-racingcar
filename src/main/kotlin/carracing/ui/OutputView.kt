package carracing.ui

import carracing.domain.Cars
import carracing.domain.Racing

object OutputView {
    fun racingResult(carCount: Int, attemptCount: Int) {
        println("실행 결과")
        Racing(Cars.of(carCount), attemptCount).race()
    }

    fun lineChange() {
        println("")
    }
}
