package study.step3

class Scoreboard {
    private val scoresList = mutableListOf<List<Score>>()

    fun addScores(scores: List<Score>) {
        scoresList.add(scores)
    }

    fun show(title: String) {
        showProcess(title)
        showWinners()
    }

    private fun showProcess(title: String) {
        with(StringBuilder()) {
            append(title)
            scoresList.forEach { scores ->
                appendLine()
                scores.forEach { score ->
                    append("${score.carName} ")
                    append("-".repeat(score.score))
                    appendLine()
                }
            }
            toString().dropLast(1)
        }.let {
            print(it)
        }
    }

    private fun showWinners() {
        val finalScores = scoresList.lastOrNull() ?: return
        val maxScore = finalScores.maxOf { it.score }
        val winnerNames: String = finalScores.filter { it.score == maxScore }.joinToString { it.carName }
        println("\n\n${winnerNames}가 최종 우승했습니다.")
    }
}
