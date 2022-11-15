package racingcar.controller

class RacingCarGameSnapShots(private val snapShots: List<RacingCarGameSnapShot>) {

    constructor(vararg snapshot: RacingCarGameSnapShot) : this(snapshot.toList())

    fun getPositions(atTrial: Int): List<Int> {
        require(atTrial > 0 && atTrial <= getNumberOfTrial()) { "Cannot get position, bigger than number of trial $atTrial" }
        return snapShots[atTrial - 1].positions
    }

    fun getNumberOfTrial(): Int {
        return snapShots.size
    }
}
