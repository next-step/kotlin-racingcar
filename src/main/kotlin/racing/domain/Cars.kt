package racing.domain

@JvmInline
value class Cars private constructor(val cars: List<Car>) {
    companion object {
        fun make(carNames: List<String>, pedal: Pedal): Cars {
            require(carNames.isNotEmpty()) {
                "1개 이상 이름이 필요합니다."
            }
            return Cars(carNames.map { name -> Car(name = name, pedal = pedal) })
        }
    }

    fun goForward() {
        cars.forEach(Car::moveForward)
    }
}
