package race

class Record(private val raceRecords: List<SnapShot>) {
    val lastRound = raceRecords.map { it.round }.maxOf { it }

    fun getSnapshotsByRound(round: Int): List<SnapShot> {
        return raceRecords.filter { it.round == round }
    }

    fun getWinnerCarName(): List<String> {
        val maxMovementsCount = getSnapshotsByRound(lastRound).maxOf { snapShot -> snapShot.carMovement.count { it } }
        val maxCarNames = raceRecords
            .filter { snapShot -> snapShot.round == lastRound }
            .filter { snapShot -> snapShot.carMovement.count { it } == maxMovementsCount }
            .map { it.carName }

        return maxCarNames.filter { it != IT_IS_NOT_MAX_MOVEMENTS_CAR }.toList()
    }

    companion object {
        private const val IT_IS_NOT_MAX_MOVEMENTS_CAR = "IT_IS_NOT_MAX_MOVEMENTS_CAR"
    }
}
