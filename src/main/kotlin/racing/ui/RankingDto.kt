package racing.ui

data class RankingDto(val winners: List<String>) {
    companion object {
        fun of(winners: List<String>) = RankingDto(winners)
    }
}