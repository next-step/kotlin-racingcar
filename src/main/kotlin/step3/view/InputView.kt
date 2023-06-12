package step3.view

import step3.domain.CarRequest
import step3.domain.RacingRequest

class InputView {
    fun inputRacingInfo(): RacingRequest {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readln().split(",")
        println("시도할 횟수는 몇 회인가요?")
        val attemptCount = readln().toInt()
        return RacingRequest(carNames.map { CarRequest(it) }, attemptCount)
    }
}
