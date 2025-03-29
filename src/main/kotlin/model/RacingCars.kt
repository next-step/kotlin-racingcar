package model

data class RacingCars(private val racingCars: List<RacingCar>) {
    companion object {
        fun fromNames(names: List<String>): RacingCars {
            val cars = names.map { RacingCar(it) }
            return RacingCars(cars)
        }
    }

    fun getRacingCars(): List<RacingCar> {
        return racingCars
    }

    fun moveAll() {
        racingCars.forEach { it.moveRandomly() }
    }
}
