package race

class Record(raceRecords: List<SnapShot>) {
    val raceRecords = raceRecords

    fun getWinnerCarName(): List<String> {
        val maxCount = raceRecords
            .last().movedCars
            .map { it.movements }
            .maxOf { movements -> movements.count { it } }

        return raceRecords
            .last().movedCars
            .filter { it.getMovedCount() == maxCount }
            .map { car -> car.name }
            .toList()
    }
}
