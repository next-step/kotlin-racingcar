package racingcar

class Game(carNames: List<String>, moveTime: Int) {
    var cars = makeCars(carNames)
        private set
    var moveTime = moveTime
        private set

    private fun makeCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it.trim()) }
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
