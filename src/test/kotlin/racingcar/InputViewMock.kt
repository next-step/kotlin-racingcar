package racingcar

class InputViewMock : InputView {
    override fun readInputNumber(): Int {
        return (0..9).random()
    }
}
