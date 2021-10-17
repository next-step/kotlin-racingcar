package racingcar.model

data class CarName(val name: String) {

    init {
        require(name.length <= 5) {
            "name must be 5 character or less"
        }
    }

    override fun toString(): String = name
}
