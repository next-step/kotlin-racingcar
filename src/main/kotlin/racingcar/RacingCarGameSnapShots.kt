package racingcar

class RacingCarGameSnapShots(cars: List<Car>) {
    private val snapShots: List<RacingCarGameSnapShot>

    init {
        val tempList = mutableListOf<RacingCarGameSnapShot>()
        for (i in cars.indices) {
            tempList.add(RacingCarGameSnapShot(cars, i + 1))
        }
        this.snapShots = tempList.toList()
    }

    fun getPositions(atTrial: Int): List<Int> {
        require(atTrial > 0 && atTrial <= getNumberOfTrial()) { "Cannot get position, bigger than number of trial $atTrial" }
        return snapShots[atTrial - 1].positions
    }

    fun getNumberOfTrial(): Int {
        return snapShots.size
    }

    class RacingCarGameSnapShot(cars: List<Car>, atTrial: Int) {
        val positions: List<Int> = cars.map { it.getPositionAt(atTrial) }.toList()
    }
}
