package study.step3

class Scoreboard {
    private val scoresList = mutableListOf<List<Score>>()

    fun addScores(scores: List<Score>) {
        scoresList.add(scores)
    }

    fun show(title: String) {
        with(StringBuilder()) {
            append(title)
            scoresList.forEach { scores ->
                appendLine()
                scores.forEach { score ->
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
