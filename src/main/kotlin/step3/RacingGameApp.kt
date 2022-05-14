package step3

fun main() {
    val cars = InputView().getCarCount()
    val tryTimes = InputView().getTryCount()
    RacingGame().play(cars, tryTimes)
}
