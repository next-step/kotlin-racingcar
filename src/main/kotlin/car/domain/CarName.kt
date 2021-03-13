package car.domain

data class CarName(val name: String) {
    init {
        require(name.length <= 5)
    }
}
