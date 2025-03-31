package model

class RacingCars(val racingCars: List<RacingCar>) {
    companion object {
        fun fromNames(names: List<String>): RacingCars {
            val cars = names.map { RacingCar(it) }
            return RacingCars(cars)
        }
    }

    fun moveAll() {
        racingCars.forEach { it.moveRandomly() }
    }

    fun size(): Int {
        return racingCars.size
    }

    fun copy(): RacingCars {
        return RacingCars(racingCars.map { it.copy() })
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RacingCars

        return racingCars == other.racingCars
    }

    override fun hashCode(): Int {
        return racingCars.hashCode()
    }
}
