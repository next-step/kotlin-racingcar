package car.domain

data class CarName(val name: String) {
    init {
        require(name.length <= MAXIMUM_NAME_LENGTH)
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}
