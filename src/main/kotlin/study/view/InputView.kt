package study.view

object InputView {
    fun askTotalRound(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readln().toIntOrNull() ?: throw IllegalArgumentException(INPUT_ERROR_MESSAGE)
    }

    fun askCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readln().split(",")
        names.forEach(this::validateName)
        return names
    }

    private fun validateName(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
}

private const val INPUT_ERROR_MESSAGE = "숫자만 입력 가능합니다."
