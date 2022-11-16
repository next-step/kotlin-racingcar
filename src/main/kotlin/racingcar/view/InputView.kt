package racingcar.view

object InputView {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readln().split(",")
    }

    fun readTryCount(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return readNumber()
    }

    private fun readNumber() = readln().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해 주세요.")
}
