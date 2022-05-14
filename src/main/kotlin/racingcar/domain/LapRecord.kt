package racingcar.domain

class LapRecord(
    val lapRecord: List<CarNameWithLocation>
) {
    fun winner(): List<CarName> {
        val topLocation = lapRecord.maxOf { it.location }
        return lapRecord.asSequence()
            .filter { it.location == topLocation }
            .map { it.carName }
            .toList()
    }
}
