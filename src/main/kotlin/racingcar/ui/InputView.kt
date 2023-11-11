package racingcar.ui

class InputView {

    var carNames: List<String> = emptyList()
        get() = field.toList()
        private set
    var attemptSize = 0
        private set

    fun show() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        carNames = readln().split(",")

        println("시도할 횟수는 몇 회인가요?")
        attemptSize = readln().toInt()
    }
}
