package car.racing

class InputView(
    private val reader: () -> String?,
    private val console: (String) -> Unit
) {

    fun readDriverNames(): List<String> {
        console("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n")
        val value: String? = reader()
        requireNotNull(value)
        require(value.isNotBlank())
        val names = value
            .tokenize()
            .regulate()
        require(names.isNotEmpty())
        return names
    }

    private fun String.tokenize(): List<String> =
        split(",").filter { it.isNotBlank() }

    private fun List<String>.regulate(): List<String> =
        map {
            val trimmed = it.trim()
            if (trimmed.length > LENGTH_OF_DRIVER_NAME) {
                trimmed.substring(0 until LENGTH_OF_DRIVER_NAME)
            } else {
                trimmed
            }
        }

    fun readMoves(): Int {
        console("시도할 횟수는 몇 회인가요?\n")
        val value: String? = reader()
        requireNotNull(value)
        return kotlin
            .runCatching { value.toInt() }
            .getOrElse { throw IllegalArgumentException() }
    }

    companion object {
        private const val LENGTH_OF_DRIVER_NAME = 5
    }
}
