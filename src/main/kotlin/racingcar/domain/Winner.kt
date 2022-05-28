package racingcar.domain

class Winner(private val result: List<List<CarHistory>>) {
    fun winner(): List<String> {
        val lastCarHistory = result.last()
        val maxPosition = lastCarHistory.maxOf { it.position }
        return lastCarHistory
            .filter { it.position == maxPosition }
            .map { it.name }
    }
}
