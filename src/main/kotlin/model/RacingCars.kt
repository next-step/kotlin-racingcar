package model

data class RacingCars(private val racingCars: List<RacingCar>) {
    companion object {
        fun fromNames(names: List<String>): RacingCars {
            return names.map {RacingCar(it)}.run {RacingCars(this)}
        }
    }

    fun getRacingCars(): List<RacingCar> {
        return racingCars
    }

    fun moveAll() {
        racingCars.forEach { it.moveRandomly() }
    }
}
