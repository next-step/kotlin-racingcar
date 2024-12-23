package study.step3.entity

class Scoreboard {
    private val scoresList = mutableListOf<List<Score>>()

    val processes: List<String>
        get() {
            return scoresList.map { scores ->
                scores.joinToString("\n") { score ->
                    "${score.carName} ${"-".repeat(score.score.value)}"
                }
            }
        }

    val winnerNames: String
        get() {
            val finalScores = scoresList.lastOrNull() ?: return ""
            val maxScore: Mileage = finalScores.maxBy { it.score.value }.score
            return finalScores.filter { it.score == maxScore }
                .joinToString { it.carName }
        }

    fun addScores(scores: List<Score>) {
        scoresList.add(scores)
    }
}
