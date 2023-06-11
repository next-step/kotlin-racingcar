package study.step3.veiw

class StdinInputView : InputView {

    override fun receive(): InputView.RacingInputResult {
        println("자동차 대수는 몇 대인가요?")
        val numOfCar = readLine()!!.toLong()
        println("시도할 횟수는 몇 회인가요?")
        val numOfAttempt = readLine()!!.toLong()
        return InputView.RacingInputResult(numOfCar, numOfAttempt)
    }
}
