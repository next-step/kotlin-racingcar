package racingcar

class Winner(cars: List<Car>) {
    var winnerList = listOf<Car>()
        private set
    private val candidateList = mutableListOf<Car>()

    init {
        winnerList = makeWinnerList(cars)
    }

    private fun makeWinnerList(carList: List<Car>): List<Car> {
        carList.forEach { changeWinnerList(it) }
        return candidateList
    }

    private fun changeWinnerList(car: Car) {
        if (candidateList.isEmpty()) {
            candidateList.add(car)
        } else {
            changeWinnerListNotEmpty(car)
        }
    }

    private fun changeWinnerListNotEmpty(car: Car) {
        when {
            isSame(car) -> {
                same(car)
            }
            isNewCarWin(car) -> {
                newCarWin(car)
            }
            isNewCarLose(car) -> {
            }
            else -> throw Exception("예상치못한 에러가 발생했습니다. Winner클래스를 수정해주세요")
        }
    }

    private fun isSame(car: Car): Boolean = candidateList[0].position == car.position

    private fun isNewCarWin(car: Car): Boolean = candidateList[0].position < car.position

    private fun isNewCarLose(car: Car): Boolean = candidateList[0].position > car.position

    private fun same(car: Car) {
        candidateList.add(car)
    }

    private fun newCarWin(car: Car) {
        candidateList.clear()
        candidateList.add(car)
    }
}
