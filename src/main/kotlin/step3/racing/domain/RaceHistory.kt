package step3.racing.domain

class RaceHistory(private val round: Int) {
    private val history: MutableList<Round> = mutableListOf()

    fun push(roundHistory: Round) {
        history.add(roundHistory)
    }

    fun getAllHistory(): List<Round> {
        if (history.size != round) throw IllegalStateException("모든 히스토리가 완성되지 않았습니다.")
        return history
    }
}
