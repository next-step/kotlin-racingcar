package racingcar

fun main() {
    val racing = InputView().startRacing()
    val results = racing.start()
    ResultView().print(results)
}
