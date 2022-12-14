package racingcar.controller

data class RacingCarGameSnapShots(val snapShots: List<RacingCarGameSnapShot>) {

    constructor(vararg snapshot: RacingCarGameSnapShot) : this(snapshot.toList())

    init {
        require(snapShots.isNotEmpty())
    }
    fun getWinnersOfGame(): List<String> {
        return snapShots.last().getWinners()
    }
}

data class RacingCarGameSnapShot(val carSnapShots: List<CarSnapShot>) {
    init {
        require(carSnapShots.isNotEmpty())
    }

    fun getWinners(): List<String> {
        val winnerPosition = carSnapShots.maxOf { it.position }

        return carSnapShots.filter { it.position == winnerPosition }.map { it.name }.toList()
    }
}

data class CarSnapShot(val name: String = "", val position: Int)
