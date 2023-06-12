package step3.entity

class RacingCar(
    val name: String,
    val position: Int = 0,
) : Comparable<RacingCar> {
    fun isOnSameLineWith(other: RacingCar): Boolean =
        this.position == other.position

    override fun compareTo(other: RacingCar): Int =
        when {
            this.position > other.position -> 1
            this.position < other.position -> -1
            else -> 0
        }

    companion object {
        fun makeCars(nameOfCars: List<String>): List<RacingCar> =
            nameOfCars.map { RacingCar(name = it) }
    }
}
