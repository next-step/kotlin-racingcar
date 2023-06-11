package step3.view

class ConsoleInputView : InputView {
    override fun getCarCount(): Int {
        print("자동차 대수는 몇 대인가요?")
        return readln().toInt()
    }

    override fun getRoundCount(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return readln().toInt()
    }
}
