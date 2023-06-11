package racingcar.domain

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= 5)
    }
}
