package racing.domain

@JvmInline
value class Round private constructor(private val result: Array<List<Pair<String, Int>>>) {
    fun raceForRound(cars: Cars, pedal: Pedal): Array<List<Pair<String, Int>>> {
        for (idx in result.indices) {
            result[idx] = cars.goForward(pedal)
        }
        return result
    }

    companion object {
        fun make(count: Int): Round {
            require(count > 0) {
                "양수만 가능합니다."
            }
            return Round(Array(count) { listOf() })
        }
    }
}
