package racingcar.domain

class CarName(val name: String) {
    private val maxNameLength = 5

    init {
        require(name.length <= maxNameLength)
    }
}
