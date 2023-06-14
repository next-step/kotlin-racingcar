package racingCar2

fun main() {
    val inputView = InputView()
    val inputIO = InputIO()

    inputView.show(InputMessage.CAR_NAMES)
    val inputNames = inputIO.inputCarNames()

    inputView.show(InputMessage.GAME_COUNT)
    val inputNumber = inputIO.inputGameCount()
}
