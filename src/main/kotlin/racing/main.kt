package racing

fun main() {
    val (carCount, attemptCount) = InputView.input()

    val cars = Cars.of(carCount, RandomNumberForwardCondition())
    val racing = Racing(cars, attemptCount)
    racing.start()

    OutputView.output(racing)
}
