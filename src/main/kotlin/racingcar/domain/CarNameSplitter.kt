package racingcar.domain

object CarNameSplitter {
    private const val CAR_NAME_DELIMITER = ","

    fun execute(target: String): List<CarName> {
        return target
            .split(CAR_NAME_DELIMITER)
            .map {
                val trimmed = it.trim()
                CarName(value = trimmed)
            }
    }
}
