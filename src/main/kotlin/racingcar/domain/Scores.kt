package racingcar.domain

class Scores(scores: List<Score>) {
    private val _scores: List<Score> = scores
    private val scores: List<Score>
        get() = _scores.toList()

    fun findAllScores(): List<Score> {
        return _scores
    }

    fun size(): Int {
        return _scores.size
    }

    fun score(index: Int): Score {
        return scores[index]
    }

    fun findWinner(): Winners {
        val maxScore = findMaxScore()
        val winners = _scores.filter { score -> score.isSameScore(maxScore) }
        return Winners(winners)
    }

    private fun findMaxScore(): Int {
        return _scores.maxByOrNull { it.point }?.point ?: 0
    }
}
