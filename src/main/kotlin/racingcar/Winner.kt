package racingcar

class Winner(cars: List<Car>) {
    var winnerList = makeWinnerList(cars)
        private set

    private fun makeWinnerList(carList: List<Car>): List<Car> {
        val maxPosition = carList.maxBy { it.position }!!.position
        return carList.filter { it.position == maxPosition }
    }
}
