package racingcar

class CarSelector(nameString: String) {

    private val _names = nameString.split(",")

    val names: List<String>
        get() = _names
}
