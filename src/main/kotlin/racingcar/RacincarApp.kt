import racingcar.InputView
import racingcar.RacingGame

fun main() {
    val carCnt = InputView("자동차 대수는 몇 대인가요?").value
    val tryCnt = InputView("시도할 횟수는 몇 회인가요?").value
    InputView("\n실행결과")
    RacingGame(carCnt, tryCnt).execute()
}
