package racingcar.domain

class Cars(
    val cars: List<Car>
) {
    fun move(): Cars {
        return Cars(emptyList())
    }
}
