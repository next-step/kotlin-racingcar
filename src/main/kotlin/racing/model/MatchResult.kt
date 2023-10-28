package racing.model

data class MatchResult(
    val result: ArrayDeque<Car>
) {
    fun consolePresent(): String {
        val presents = result.stream()
            .map { "-".repeat(it.position) }
            .toArray()
        return presents.joinToString(separator = "\n")
    }
}
