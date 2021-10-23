package racingcar.domain

class RacingController {

    fun race(participants: RacingCars): RacingCars {
        return participants.race()
    }

    fun record(board: BulletinBoard, participants: RacingCars, lap: Lap): BulletinBoard {
        return board.record(participants, lap)
    }
}
