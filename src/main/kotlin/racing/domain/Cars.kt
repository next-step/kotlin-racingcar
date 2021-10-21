package racing.domain

@JvmInline
value class Cars private constructor(val cars: List<Car>) {
    companion object {
        fun make(count: Int, pedal: Pedal): Cars {
            require(count > 0) {
                "양수만 가능합니다."
            }
            return Cars(List(count) { Car(pedal) })
        }
    }

    fun goForward() {
        cars.forEach(Car::moveForward)
    }
}
