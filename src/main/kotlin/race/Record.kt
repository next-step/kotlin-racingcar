package race

class Record(raceRecords: List<SnapShot>) {
    val raceRecords = raceRecords

    fun getWinnerCarName(): List<String> {
        val maxCount = raceRecords
            .last().carMovements
            .map { it }
            .maxOf { movements -> movements.count { it } }

        val maxCarNames = raceRecords
            .last().carMovements
            .mapIndexed { index, movements ->
                if (movements.count { it } == maxCount) {
                    raceRecords.last().carNames[index]
                } else IT_IS_NOT_MAX_MOVEMENTS_CAR
            }
        return maxCarNames.filter { it != IT_IS_NOT_MAX_MOVEMENTS_CAR }.toList()
    }

    companion object {
        private const val IT_IS_NOT_MAX_MOVEMENTS_CAR = "IT_IS_NOT_MAX_MOVEMENTS_CAR"
    }
}
