package step3.entity

class RacingCar(
    val name: String,
    val position: Int = 0,
) : Comparable<RacingCar> {
    init {
        require(name.isNotEmpty()) { "빈 문자열은 이름이 될 수 없습니다." }
        require(name.length <= 5) { "자동차의 이름은 다섯자를 넘을 수 없습니다." }
    }

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
            nameOfCars.map {
                RacingCar(name = it)
            }
    }
}
