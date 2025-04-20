package camp.nextstep.edu.view

object InputHandler {
    private const val NAME_DELIMITER = ","
    private const val MAX_NAME_LENGTH = 5
    private const val MIN_MOVE_COUNT = 1

    fun readCarNames(): List<String> {
        while (true) {
            try {
                println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
                val input = readlnOrNull() ?: throw IllegalStateException("[ERROR] 입력을 읽을 수 없습니다.")
                return parseAndValidateNames(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    private fun parseAndValidateNames(input: String): List<String> =
        input.split(NAME_DELIMITER)
            .map { it.trim() }
            .also { ::validationCarNames }


    private fun validationCarNames(names: List<String>) {
        require(!names.any { it.isBlank() || it.length > MAX_NAME_LENGTH }) { "[ERROR] 자동차 이름은 1자 이상 $MAX_NAME_LENGTH 자 이하여야 합니다." }
    }


    fun getNumberOfMoves(): Int {
        while (true) {
            try {
                println("시도할 횟수를 입력하세요:")
                val input =
                    readlnOrNull() ?: throw IllegalArgumentException("[ERROR] 횟수를 입력해야 합니다.")
                return parseAndValidateMoveCount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println("[ERROR] 유효한 숫자를 입력해야 합니다.")
            }
        }
    }

    private fun parseAndValidateMoveCount(input: String): Int =
        input.toInt().also(::validateMoveCount)

    private fun validateMoveCount(count: Int) {
        require(count >= MIN_MOVE_COUNT) { "[ERROR] 시도 횟수는 $MIN_MOVE_COUNT 이상이어야 합니다." }
    }

}