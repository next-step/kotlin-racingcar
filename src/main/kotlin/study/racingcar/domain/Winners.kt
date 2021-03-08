package study.racingcar.domain

class Winners(
    racedCars: List<Car>
) {
    var winners: List<Car>? = racedCars
        .groupBy { it.moveCount }
        .maxBy { it.key }?.value
        private set

    override fun toString(): String {
        return winners?.map { it.carName }?.joinToString(", ") ?: throw IllegalAccessException()
    }
}
