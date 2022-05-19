import racingcar.InputView
import racingcar.RacingGame

fun main() {
    val inputView = InputView()
    val carCnt = inputView.readCarCount()
    val tryCnt = inputView.readTryCount()
    println("\n실행결과")
    RacingGame(carCnt, tryCnt).execute()
}
