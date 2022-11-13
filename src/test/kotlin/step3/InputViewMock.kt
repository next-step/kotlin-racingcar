package step3

class InputViewMock : InputView {
    override fun readInputNumber(): Int {
        return (0..9).random()
    }
}
