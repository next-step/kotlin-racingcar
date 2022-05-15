package racingcar.domain

data class CarResult(
    val name: String,
    val position: Int
) {
    companion object {
        fun of(car: Car): CarResult = CarResult(car.name, car.position)
    }
}
