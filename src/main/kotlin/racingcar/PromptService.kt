package racingcar

class PromptService(
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun getNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return inputView.readInputNumber()
    }

    fun getNumberOfMoves(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return inputView.readInputNumber()
    }

    fun showResult(result: List<List<Int>>) {
        resultView.show(result)
    }
}
