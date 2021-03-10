package study.racingcar.domain

class Winners(
    racedCars: List<Car>,
    val winners: List<Car> = racedCars
        .groupBy { it.moveCount }
        .maxBy { it.key }?.value ?: throw IllegalStateException()
) {

    override fun toString(): String {
        return winners.joinToString(", ") { it.carName }
    }
}
