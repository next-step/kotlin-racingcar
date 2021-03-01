package racingcar_winner

class Cars(
    private val cars: List<Car>
) {
    override fun toString(): String {
        return cars.joinToString { car -> car.name }
    }
}
