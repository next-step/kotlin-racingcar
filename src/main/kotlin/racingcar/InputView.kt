package racingcar

class InputView {

    fun show() {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCar: String? = readLine()

        println("시도할 횟수는 몇 회인가요?")
        val numberOfGame: Int? = readLine()?.toIntOrNull()

        val result = FormularOne().start(numberOfCar, numberOfGame)

        ResultView().show(result)
    }
}
