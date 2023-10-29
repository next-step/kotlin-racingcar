package study.racing

import study.racing.process.Racing
import study.racing.view.RacingView

fun main() {

    val carNames = RacingView.inputRacingCarNamesParameters("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    val roundCount = RacingView.inputRacingRoundParameters("시도할 횟수는 몇 회인가요?")

    Racing().playRacing(carNames, roundCount)
}
