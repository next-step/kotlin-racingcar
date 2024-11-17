package race

data class RaceResult(val rounds: List<RaceRound>) {
    val winners: List<String> =
        rounds
            .flatMap { it.round }
            .groupBy({ it.first }, { it.second })
            .mapValues { it.value.maxOrNull() ?: 0 }
            .let { scoreMap ->
                val maxScore = scoreMap.values.maxOrNull() ?: 0
                scoreMap.filterValues { it == maxScore }.keys.toList()
            }
}
