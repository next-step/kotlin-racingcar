package racingcar

object InputView {
    private const val NAME_SEPARATOR = ","

    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return getCarNameInput()
    }

    fun getGameCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return getNumberInput()
    }

    private fun getCarNameInput(): List<String> {
        val names = readln()
        require(names.isNotBlank()) { "이름을 입력해주세요." }
        return names.split(NAME_SEPARATOR)
    }

    private fun getNumberInput(): Int {
        return requireNotNull(readln().toIntOrNull()) { "숫자를 입력해주세요." }
    }
}
