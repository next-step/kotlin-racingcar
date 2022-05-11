package step3.racingcar

object CarRacing {

    fun execute(carCount: Int, moveCount: Int): ArrayList<Car> {
        val carList = ArrayList<Car>()
        repeat(carCount) {
            carList.add(Car(executeCarMovements(moveCount)))
        }
        return carList
    }

    private fun executeCarMovements(moveCount: Int): ArrayList<Boolean> {
        val movements = ArrayList<Boolean>()
        movements.initialize()
        repeat(carMoveCount(moveCount)) {
            movements.add(isCarMove())
        }
        return movements
    }

    private fun ArrayList<Boolean>.initialize() = this.add(true)

    private fun carMoveCount(moveCount: Int) = moveCount.minus(1)
    private fun isCarMove() = (0..9).random() >= GO_NUMBER

    private const val GO_NUMBER = 4
}
