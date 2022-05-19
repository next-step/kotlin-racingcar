package racingcar.domain

class RacingResult(
    private val _value: List<Cars>,
) {
    val value: List<Cars>
        get() = _value

    fun getWinners(): List<Name> {
        val finalResult = _value.last()
        return finalResult.findAllEqualPositionTo(finalResult.maxPosition)
    }
}
