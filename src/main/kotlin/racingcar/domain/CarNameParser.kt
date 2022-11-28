package racingcar.domain

object CarNameParser {
    private const val CAR_NAME_PARSE_DELIMITER = ","

    fun parse(carNames: String): List<String> = carNames.split(CAR_NAME_PARSE_DELIMITER)
}
