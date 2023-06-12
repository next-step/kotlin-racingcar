package racing

@JvmInline
value class Cars(
    val cars: List<Car>,
) {
    fun play(movePolicy: MovePolicy) {
        cars.forEach {
            it.move(movePolicy)
        }
    }

    companion object {
        fun of(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }
}
