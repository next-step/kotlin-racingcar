package step3

class Cars(
    private val cars: List<Car>
) {

    fun race() {
        cars.forEach { it.race() }
    }

    fun getCarDistances(): List<Int> {
        return cars.map { it.distance }
    }
}
