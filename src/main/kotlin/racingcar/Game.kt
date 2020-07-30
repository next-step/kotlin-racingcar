package racingcar

class Game(carNames: List<String>, moveTime: Int) {
    var cars = listOf<Car>()
        private set
    var moveTime = moveTime
        private set

    init {
        cars = makeCars(carNames)
    }

    private fun makeCars(carNames: List<String>): List<Car> {
        val carList = mutableListOf<Car>()
        carNames.forEach {
            val car = Car(it.trim())
            carList.add(car)
        }
        return carList
    }

    fun race() {
        moveTime -= 1
        for (car in cars) {
            car.goStop(randomValue())
        }
    }

    fun isEndGame(): Boolean = moveTime == 0

    private fun randomValue(): Int = (0..9).random()
}
