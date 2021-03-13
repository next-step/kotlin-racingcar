package car.business

data class CarName(val name: String) {
    init {
        require(name.length <= 5)
    }
}
