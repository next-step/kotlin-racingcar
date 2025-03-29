package model

data class RacingCars(val racingCars: List<RacingCar>) {
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
}
