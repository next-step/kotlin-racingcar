package racingcar.controller

data class RacingCarGameSnapShots(val snapShots: List<RacingCarGameSnapShot>) {

    constructor(vararg snapshot: RacingCarGameSnapShot) : this(snapshot.toList())

    fun getPositions(atTrial: Int): List<Int> {
        require(atTrial > 0 && atTrial <= getNumberOfTrial()) { "Cannot get position, bigger than number of trial $atTrial" }
        return snapShots[atTrial - 1].carSnapShots.map { it.position }
    }

    fun getNumberOfTrial(): Int {
        return snapShots.size
    }

    fun getCarSnapshots(atTrial: Int): List<CarSnapShot> {
        require(atTrial > 0 && atTrial <= getNumberOfTrial()) { "Cannot get snapshot, bigger than number of trial $atTrial" }
        return snapShots.get(atTrial).carSnapShots
    }
}

data class RacingCarGameSnapShot(val carSnapShots: List<CarSnapShot>)

data class CarSnapShot(val name: String = "", val position: Int)
