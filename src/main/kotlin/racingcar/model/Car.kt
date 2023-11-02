package racingcar.model

class Car(
    val name: String,
    private var distance: Int = 0
) {
    fun move(offset: Int = 1) {
        distance += offset
    }

    fun getDistance(): Int {
        return distance
    }

    companion object {
        fun create(carNames: List<String>): List<Car> {
            return carNames.map {
                Car(it)
            }
        }
    }
}
