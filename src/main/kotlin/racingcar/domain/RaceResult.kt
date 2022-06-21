package racingcar.domain

@JvmInline value class Trial(val value: Int)

class RaceResult(
    val result: Map<Trial, Cars>
)
