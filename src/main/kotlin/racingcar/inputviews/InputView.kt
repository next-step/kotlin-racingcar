package racingcar.inputviews

data class GameInput(val numberOfCars: Int, val numberOfRounds: Int)

interface InputView {
    fun receiveInput(): GameInput
}
