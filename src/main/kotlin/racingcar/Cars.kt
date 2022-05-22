package racingcar

@JvmInline
value class Cars(val value: List<Car>) {

    fun moveForwardAll(refuels: List<Int>): Cars {
        val carsAndRefuels = value.zip(refuels) { car, refuel -> car.moveForward(refuel) }
        return Cars(carsAndRefuels)
    }

    fun size(): Int {
        return value.size
    }

    companion object {
        fun initCars(carNames: CarNames): Cars {
            return Cars(List(size = carNames.size()) { Car(name = carNames.get(it)) })
        }
    }
}
