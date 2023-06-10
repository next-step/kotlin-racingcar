package step3

class Racing(
    private val cars: List<Car>
) {
    fun race() {
        cars.forEach {
            it.move()
        }
    }
}
