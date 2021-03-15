package car.domain

class Winners(carCollection: CarCollection) {
    val winners: List<Winner> = carCollection.cars
        .filter { it.isWinner(carCollection.maxPosition) }
        .map { Winner(it.carName) }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
