package racingcar.domain

@JvmInline
value class Records private constructor(val values: List<Record>) {

    companion object {
        fun of(participants: RacingCars): Records {
            val values = participants.values.map { Record(it) }
            return Records(values)
        }
    }
}
