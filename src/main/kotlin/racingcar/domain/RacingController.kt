package racingcar.domain

class RacingController() {
    val board = BulletinBoard()

    fun race(participants: RacingCars, lap: Lap): RacingCars {
        val result = participants.race()
        board.record(result, lap)
        return result
    }
}
