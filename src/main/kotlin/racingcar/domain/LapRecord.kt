package racingcar.domain

class LapRecord(
    val carRecords: List<CarRecord>
) {
    fun winner(): List<CarName> {
        val topLocation = carRecords.maxOf { it.location }
        return carRecords.asSequence()
            .filter { it.location == topLocation }
            .map { it.carName }
            .toList()
    }
}
