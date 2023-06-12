package racingcar.util

object InputValidator {
    @Throws(IllegalArgumentException::class)
    fun carNameInputValidate(input: String?) {
        require(!input.isNullOrBlank()) { "자동차 이름을 입력해주세요" }

        val names = InputParser.parseCarNames(input)
        if (names.size != names.filter { it.length <= 5 }.size) {
            throw IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.")
        }
    }

    @Throws(IllegalArgumentException::class)
    fun turnCountValidate(input: String?) {
        require(!input.isNullOrBlank()) { "시도할 횟수를 입력해주세요" }

        input.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수는 정수만 입력 가능합니다")
    }
}
