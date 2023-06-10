package study.racingcar.view

class InputView : InputConsole {
    override fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readLine() ?: ""
        val carNames = names.split(",").map { it.trim() }.filter { it.isNotBlank() }

        return carNames.ifEmpty { listOf("Guest") }
    }

    override fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()?.toIntOrNull() ?: throw NumberFormatException("유효한 숫자를 입력하세요.")
    }
}
