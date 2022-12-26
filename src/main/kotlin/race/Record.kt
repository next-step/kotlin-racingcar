package race

class Record(val raceSnapshots: List<SnapShot>) {
    val carNames = raceSnapshots.map { it.carName }.distinct()
    val lastRound = raceSnapshots.map { it.round }.maxOf { it }
}
