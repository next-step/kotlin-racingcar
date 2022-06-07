package racingcar.domain

class RacingResult(
    private val _value: List<RacingRecord>,
) {
    val value: List<RacingRecord>
        get() = _value
}
