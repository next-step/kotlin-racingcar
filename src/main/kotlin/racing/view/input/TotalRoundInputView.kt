package racing.view.input

class TotalRoundInputView : InputView<Int>() {
    override val message: String = "시도할 횟수는 몇 회인가요?"
    override var value: Int = 0

    init {
        this.renderMessage()
        val value = readln().toInt()
        this.value = value
    }
}
