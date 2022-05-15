package racingcar.presentation

class InBoundView(
    private val reader: () -> String,
    private val printer: (String) -> Unit
) {
    fun requestNumberOfPlayer(): Int {
        printer("자동차 대수는 몇 대인가요?: ")
        return readText()
    }

    fun requestNumberOfMove(): Int {
        printer("시도할 횟수는 몇 회인가요?: ")
        return readText()
    }

    private fun readText(): Int {
        val number: String = requireNotNull(reader())
        return runCatching { number.toInt() }
            .getOrElse { throw IllegalArgumentException() }
    }
}
