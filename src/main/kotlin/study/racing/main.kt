package study.racing

import study.racing.process.Racing
import study.racing.view.RacingView

fun main() {

    val carCount = RacingView.inputRacingParameters("자동차 대수는 몇 대인가요?")
    val roundCount = RacingView.inputRacingParameters("시도할 횟수는 몇 회인가요?")

    Racing().playRacing(carCount, roundCount)
}
