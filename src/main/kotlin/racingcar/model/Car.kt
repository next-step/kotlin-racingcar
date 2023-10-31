package racingcar.model

class Car(
    private var distance: Int = 0
) {
    fun move(offset: Int = 1) {
        distance += offset
    }

    fun getDistance(): Int {
        return distance
    }

    companion object {
        fun create(carNumber: Int): List<Car> {
            val cars: MutableList<Car> = mutableListOf()

            for (i: Int in 0 until carNumber) {
                cars.add(Car())
            }

            return cars.toList()
        }
    }
}
