package racingcar

class Winner(private val carRacing: CarRacing) {
    fun names(): List<Name> {
        val result = carRacing.race()
        val recordByRound = result.toMap()
        val finalRound = recordByRound.keys.last()
        val winnerPosition = recordByRound[finalRound]?.maxOf { it.position.value }

        return recordByRound[finalRound]?.filter { it.position.value == winnerPosition }
            ?.map { it.name } ?: emptyList()
    }
}
