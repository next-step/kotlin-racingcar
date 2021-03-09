package racing.domain

import racing.CAR_NAME_LENGTH_LIMIT

class CarNameParser {
    fun parse(carNameLine: String): List<String> {
        val names = carNameLine.split(CAR_NAME_DELIMITER)
        names.forEach {
            require(it.length <= CAR_NAME_LENGTH_LIMIT)
        }

        return names
    }

    companion object {
        const val CAR_NAME_DELIMITER = ","
    }
}
