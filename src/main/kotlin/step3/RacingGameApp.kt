package step3

fun main() {
    val cars = InputView().getCarCount()
    val tryTimes = InputView().getTryCount()
    val carList = List(cars) { Car() }
    RacingGame(carList, tryTimes).play()
}
