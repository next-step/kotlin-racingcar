package racing.model

data class MatchResult(
    val result: ArrayDeque<Car>
) {
    fun consolePresent(): String {
        return result.stream()
            .map { "-".repeat(it.position) }
            .toArray()
            .joinToString(separator = "\n")
    }
}
