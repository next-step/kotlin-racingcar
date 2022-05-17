package step3.racing

class RacingTrack(racerNames: List<String>, val times: Int) {
    val racers: List<Car> = buildList {
        repeat(racerNames.size) { add(Car(racerNames[it])) }
    }

    fun start() = repeat(times) {
        racers.forEach {
            it.run(RandomGenerator.getInt(0, 9))
            ResultView.showDistance(it.name, it.distance)
        }
        println()
    }

    fun getWinnerNames(): List<String> {
        return Referee.findWinnerNames(racers)
    }
}
