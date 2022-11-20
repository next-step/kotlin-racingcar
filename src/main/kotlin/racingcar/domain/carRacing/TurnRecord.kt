package racingcar.domain.carRacing

class TurnRecord(
    val turn: Int,
    val results: List<CarRecord>
) {
    fun winners(maxDistance: Int): List<Car> {
        return results.filter { it.distance == maxDistance }
            .map { it.car }
    }
}
