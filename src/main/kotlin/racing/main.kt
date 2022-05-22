package racing

import racing.view.RacingView

const val DELIMITER = ","
fun main() {
    try {
        println("경주할 자동차 이름을 입력하세요")
        val carNames = readln().split(DELIMITER)

        println("시도할 횟수는 몇 회인가요?")
        val tryRound = readln().toInt()

        RacingView.result(tryRound, Racing.start(carNames, tryRound))
    } catch (e: NumberFormatException) {
        println("숫자가 아닌 값이 들어왔습니다")
    }
}
