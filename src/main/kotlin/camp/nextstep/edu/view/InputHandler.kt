package camp.nextstep.edu.view

object InputHandler {
    private const val NAME_DELIMITER = ","
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_MOVE_COUNT = 1

    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = readlnOrNull()
        return parseAndValidateNames(input)
    }

    private fun parseAndValidateNames(input: String?): List<String> {
        requireNotNull(input) { "[ERROR] 입력을 읽을 수 없습니다." }
        return input.split(NAME_DELIMITER)
            .map { it.trim() }
            .also(::validateCarNames)
    }

    private fun validateCarNames(names: List<String>) {
        require(names.all { it.isNotBlank() && it.length <= MAX_NAME_LENGTH }) { "[ERROR] 자동차 이름은 1자 이상 ${MAX_NAME_LENGTH}자 이하여야 합니다." }
    }

    fun getNumberOfMoves(): Int {
        println("시도할 횟수를 입력하세요:")
        val input = readlnOrNull()
        return parseAndValidateMoveCount(input)
    }

    private fun parseAndValidateMoveCount(input: String?): Int {
        val count = input?.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효한 숫자를 입력해야 합니다.")
        validateMoveCount(count)
        return count
    }

    private fun validateMoveCount(count: Int) {
        require(count >= MIN_MOVE_COUNT) { "[ERROR] 시도 횟수는 $MIN_MOVE_COUNT 이상이어야 합니다." }
    }

}