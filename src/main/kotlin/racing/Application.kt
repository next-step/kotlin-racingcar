package racing

fun main() {
    val inputView = InputView()
    val numberOfCars = inputView.get("자동차 대수는 몇 대인가요?")
    val tryCount = inputView.get("시도할 횟수는 몇 회인가요?")

    Game(numberOfCars, tryCount).start()
}