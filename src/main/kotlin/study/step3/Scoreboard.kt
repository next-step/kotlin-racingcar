package study.step3

class Scoreboard {
    private val scoresList = mutableListOf<List<Score>>()

    fun addScores(scores: List<Score>) {
        scoresList.add(scores)
    }

    fun show(title: String) {
        showProcess(title)
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
}
