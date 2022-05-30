package racingcar.domain

private const val DEFAULT_DELIMITER = ","

object CarSelector {

    fun select(nameString: String): List<Car> {
        return getNames(nameString).map { (Car(it)) }
    }

    private fun getNames(nameString: String): List<String> {
        return nameString.split(DEFAULT_DELIMITER)
    }
}
