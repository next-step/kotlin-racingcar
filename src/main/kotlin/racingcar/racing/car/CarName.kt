package racingcar.racing.car

data class CarName(val name: String) {
    init {
        require(name.length <= 5) {
            "The length of name must be less than 6. name='$name'"
        }
    }
}
