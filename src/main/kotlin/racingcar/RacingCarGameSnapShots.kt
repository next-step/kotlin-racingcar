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
        return snapShots[atTrial - 1].getPositions()
    }

    fun getNumberOfTrial(): Int {
        return snapShots.size
    }

    inner class RacingCarGameSnapShot(cars: List<Car>, atTrial: Int) {
        private val positionByCar: Map<Int /*carIdx*/, Int /*position*/>

        init {
            this.positionByCar = cars.map { it.order to it.getPositionAt(atTrial) }.toMap().toSortedMap()
        }

        fun getPositions(): List<Int> {
            return positionByCar.values.toList()
        }
    }
}
