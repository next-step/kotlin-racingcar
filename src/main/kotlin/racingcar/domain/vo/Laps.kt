package racingcar.domain.vo

@JvmInline
value class Laps private constructor(val values: List<Lap>) {
    init {
        require(values.isNotEmpty()) { "한 바퀴 이상 경주해야 합니다." }
    }

    companion object {
        fun of(rounds: String?): Laps {
            require(!rounds.isNullOrBlank()) {}
            require(rounds.toIntOrNull() != null) {}
            return of(rounds.toInt())
        }
        fun of(rounds: Int): Laps = Laps((1..rounds).map { Lap(it) })
        fun of(laps: Set<Lap>): Laps {
            return Laps(laps.sortedBy { it.round })
        }
    }
}
