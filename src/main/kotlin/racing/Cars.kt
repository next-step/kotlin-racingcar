package racing

class Cars(
    val cars: List<Car>,
) {
    companion object {
        fun of(carCount: Int): Cars {
            return Cars(List(carCount) { Car() })
        }
    }

    fun play(movePolicy: MovePolicy) {
        cars.forEach {
            it.move(movePolicy)
        }
    }
}
