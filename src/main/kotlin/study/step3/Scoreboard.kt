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
        println("\n$title")
        scoresList.joinToString("\n\n") { scores ->
            scores.joinToString("\n") { score ->
                "${score.carName} ${"-".repeat(score.score.value)}"
            }
        }.let {
            println(it)
        }
    }

    private fun showWinners() {
        val finalScores = scoresList.lastOrNull() ?: return
        val maxScore: Mileage = finalScores.maxBy { it.score.value }.score
        val winnerNames: String = finalScores.filter { it.score == maxScore }.joinToString { it.carName }
        print("\n${winnerNames}가 최종 우승했습니다.")
    }
}
