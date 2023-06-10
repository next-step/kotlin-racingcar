package step3.view

import step3.domain.RacingRequest

class InputView {
    fun inputRacingInfo(): RacingRequest {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readln().toInt()
        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readln().toInt()
        return RacingRequest(carCount, tryCount)
    }
}
