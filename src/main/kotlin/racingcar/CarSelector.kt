package racingcar

class CarSelector(nameString: String) {

    val names = nameString.split(DEFAULT_DELIMITER)

    companion object {
        private const val DEFAULT_DELIMITER = ","
    }
}
