package racingcar.domain

@JvmInline
value class CarName(val name: String) {
    init {
        require(name.length <= maxNameLength)
    }

    companion object {
        private const val maxNameLength = 5
    }
}
