package racingcar

class Cars private constructor(private val allCars: ArrayList<Car>) {
    companion object {
        fun makeCars(numOfCars: Int): Cars {
            var cars = ArrayList<Car>()
            for (i in 1..numOfCars) {
                cars.add(Car())
            }

            return Cars(cars)
        }
    }

    fun getNumberOfCars(): Int {
        return allCars.size
    }

    fun getCars(): List<Car> {
        return allCars
    }
}
