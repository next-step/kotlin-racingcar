package car.racing

class InputView(
    private val reader: () -> String?,
    private val console: (String) -> Unit
) {

    fun readDrivers(): Int {
        console("자동차 대수는 몇 대인가요?: ")
        return readInt()
    }

    fun readMoves(): Int {
        console("시도할 횟수는 몇 회인가요?: ")
        return readInt()
    }

    private fun readInt(): Int {
        val value: String? = reader()
        requireNotNull(value)
        return kotlin
            .runCatching { value.toInt() }
            .getOrElse { throw IllegalArgumentException() }
    }
}
