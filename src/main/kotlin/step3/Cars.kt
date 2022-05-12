package step3

import java.util.function.Consumer

class Cars private constructor(count: Int) {
    var carsList: List<Car>

    init {
        val cars: MutableList<Car> = ArrayList(count)
        for (i in 0 until count) {
            cars.add(Car.instance)
        }
        this.carsList = cars
    }

    companion object {
        fun from(count: Int): Cars {
            return Cars(count)
        }
    }

    fun run(movingStrategy: MovingStrategy?) {
        carsList.forEach(Consumer { car: Car -> car.move(movingStrategy!!) })
    }
}

