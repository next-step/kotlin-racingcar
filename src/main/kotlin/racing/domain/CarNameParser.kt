package racing.domain

object CarNameParser {
    fun parse(carNameLine: String): List<String> {
        val names = carNameLine.split(CAR_NAME_DELIMITER)
        require(names.all { it.length <= CAR_NAME_LENGTH_LIMIT })

        return names
    }

    private const val CAR_NAME_DELIMITER = ","
    private const val CAR_NAME_LENGTH_LIMIT = 5
}
