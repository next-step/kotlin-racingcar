package racing.model

class MatchResult(
    val result: List<Car>
) {
    fun consolePresent(): String {
        val presents = result.stream()
            .map { "-".repeat(it.position) }
            .toList()
        return presents.joinToString(separator = "\n")
    }
}
