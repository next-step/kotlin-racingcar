package racingcar.domain.car

object CarNameParser {
    private const val DELIMITER = ","

    fun parse(carNames: String) = carNames.split(DELIMITER)
}
