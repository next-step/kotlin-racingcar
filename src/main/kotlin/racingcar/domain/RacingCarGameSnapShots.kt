package racingcar.domain

data class RacingCarGameSnapShots(val snapShots: List<RacingCarGameSnapShot>, val winnerOfGame: List<String>) {

    init {
        require(snapShots.isNotEmpty())
    }
}

data class RacingCarGameSnapShot(val carSnapShots: List<CarSnapShot>) {
    init {
        require(carSnapShots.isNotEmpty())
    }
}

data class CarSnapShot(val name: String = "", val position: Int)
