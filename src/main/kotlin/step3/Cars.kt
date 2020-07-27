package step3

class Cars(
    private val cars: List<Car>
) {
    fun race() {
        cars.forEach { it.race() }
    }

    fun getCurrentRacingTracks(): List<RacingTrack> {
        return cars.map { RacingTrack(it.name, it.distance) }
    }
}
