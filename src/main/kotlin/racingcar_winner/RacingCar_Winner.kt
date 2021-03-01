package racingcar_winner

private val inputView = InputView()
private val carFactory = CarFactory()

fun main() {
    val carNames = inputView.inputCarNames()
    val numberOfRound = inputView.inputNumberOfRound()

    val cars = carFactory.orderMakingCars(carNames)
    println(cars.toString())
}
