package step3

class Car(var position: Int = 0) {
    fun move() {
        position++
    }

    companion object {
        @JvmStatic
        fun makeCars(carCount: Int): MutableList<Car> {
            val cars = mutableListOf<Car>()
            for (i in 0 until carCount) {
                cars.add(Car())
            }
            return cars
        }
    }
}
