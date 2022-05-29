package racingcar.domain

class CarNames(private val values: List<CarName>) {

    fun size(): Int {
        return this.values.size
    }

    operator fun get(index: Int): CarName {
        return this.values[index]
    }

    companion object {
        fun of(carNames: List<String>): CarNames {
            val values: List<CarName> = carNames.map { carName -> CarName.of(carName) }
            return CarNames(values)
        }
    }
}
