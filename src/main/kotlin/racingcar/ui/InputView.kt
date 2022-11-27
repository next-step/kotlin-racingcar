package racingcar.ui

class InputView {

    var numberOfGame: Int = 0
        private set
    var carNamesString: String = ""
        private set

    fun show() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        carNamesString = readLine() ?: ""

        println("시도할 횟수는 몇 회인가요?")
        numberOfGame = readLine()?.toIntOrNull() ?: 0
    }
}
