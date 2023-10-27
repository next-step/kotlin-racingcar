package racing.model

class Racing {
    fun race(participate: Int, repeat: Int): List<MatchResult> {
        val mat: MatchResult = ready()
        val list: MutableList<MatchResult> = mutableListOf()
        for (i in 1..repeat) {
            val roundResult = roundGo(participate, mat)
            list.add(roundResult)
        }
        return list
    }

    private fun ready(): MatchResult {
        TODO()
    }

    private fun roundGo(participate: Int, preMatchResult: MatchResult): MatchResult {
        TODO()
    }
}
