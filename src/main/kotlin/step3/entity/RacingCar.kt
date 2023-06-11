package step3.entity

class RacingCar(
    val name: String,
    val position: Int = 0,
) {
    companion object {
        fun makeCars(nameOfCars: List<String>): List<RacingCar> =
            nameOfCars.map { RacingCar(name = it) }
    }
}
