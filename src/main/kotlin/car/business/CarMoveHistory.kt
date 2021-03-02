package car.business

data class CarMoveHistory(val car: Car, val position: Int) {
    override fun toString(): String {
        return "${car.name} : ${"-".repeat(position)}"
    }
}