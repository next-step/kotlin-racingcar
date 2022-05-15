package racingcar

class CarSelector(nameString: String) {

    private val _names = nameString.split(DEFAULT_DELIMITER)

    val names: List<String>
        get() = _names

    companion object {
        private const val DEFAULT_DELIMITER = ","
    }
}
