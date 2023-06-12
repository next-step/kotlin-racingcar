package racing.view.input

class CarInputView : InputView<Int>() {
    override val message: String = "자동차 대수는 몇 대인가요?"
    override var value: Int = 0

    init {
        this.renderMessage()
        val value = readln().toInt()
        this.value = value
    }
}
