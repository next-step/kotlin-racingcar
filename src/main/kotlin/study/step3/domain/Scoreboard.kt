package study.step3.domain


class Scoreboard : MutableList<List<Scoreboard.Item>> by mutableListOf() {

    val processes: List<String>
        get() {
            return map { scores ->
                scores.joinToString("\n") { item ->
                    "${item.title} ${"-".repeat(item.score)}"
                }
            }
        }

    val winnerNames: List<String>
        get() {
            val finalScores = lastOrNull() ?: return emptyList()
            val maxScore: Int = finalScores.maxBy { it.score }.score
            return finalScores.filter { it.score == maxScore }
                .map { it.title }
        }

    data class Item(
        val title: String,
        val score: Int,
    )
}
