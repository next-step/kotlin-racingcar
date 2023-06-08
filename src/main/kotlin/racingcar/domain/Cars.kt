package racingcar.domain

class Cars(count: Int) {
    private val cars: MutableList<Car> = ArrayList()
    private val GO_CONDITION = 4

    init {
        for (i in 0 until count) {
            cars.add(Car())
        }
    }

    fun attempt() {
        for (car in cars) {
            if (RandomState().randomInt > GO_CONDITION) {
                car.go()
            }
        }
    }

    fun countCars() = cars.size

    val scores: List<Int>
        get() = cars.map(Car::score)
}
