package step3.racing

class RacingTrack(racerNames: List<String>, private val times: Int) {
    val racers: List<Car> = racerNames.map { Car(it) }

    fun start() = repeat(times) {
        racers.forEach {
            it.run(RandomGenerator.getInt(0, 9))
            ResultView.showDistance(it.name, it.distance)
        }
        println()
    }
}
