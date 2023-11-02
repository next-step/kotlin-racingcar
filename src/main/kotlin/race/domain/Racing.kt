package race.domain

class Racing(
    private val racingCarList: List<RacingCar>,
    private val round: Int,
    private val goRule: () -> Boolean = {
        (0..10).random() >= 4
    },
) {
    init {
        require(round > 0) { "Must be at least one round!" }
    }

    fun startRace(): RacingResult = RacingResult(rounds = List(size = round) {
        startRound()
        racingCarList.map { RacingCar(name = it.name, space = it.space) }
    })

    private fun startRound() {
        racingCarList.forEach {
            if (goRule()) {
                it.go()
            }
        }
    }
}
