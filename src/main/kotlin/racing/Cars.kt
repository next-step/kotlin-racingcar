package racing

class Cars(
    val cars: List<Car>
) {

    companion object {
        fun of(carCount: Int, forwardCondition: ForwardCondition): Cars {
            val cars = (0 until carCount)
                .map { Car(forwardCondition = forwardCondition) }

            return Cars(cars = cars)
        }
    }

    fun racing() {
        cars.forEach { car -> car.move() }
    }
}
