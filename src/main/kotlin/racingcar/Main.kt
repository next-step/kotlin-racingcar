package racingcar

fun main() {
    val inputView = InputView()

    val racingCar = RacingCar(inputView.carCount, inputView.playCount)

    OutputView(racingCar.carList)
}
