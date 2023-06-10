package racing

class Cars(
    private val cars: List<Car>
) {

    companion object {
        fun of(carCount: Int, forwardCondition: ForwardCondition): Cars {
            val cars = (0 until carCount)
                .map { Car(forwardCondition = forwardCondition) }

            return Cars(cars = cars)
        }
    }

    fun race(): List<Car> {
        cars.forEach { car -> car.move() }
        return cars
    }
}
