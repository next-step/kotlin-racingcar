package racingcar

class Game(carNum: Int, moveTime: Int) {
    var cars = listOf<Car>()
        private set
    var moveTime = moveTime
        private set

    init {
        cars = makeCars(carNum)
    }

    private fun makeCars(number: Int): List<Car> {
        val carList = mutableListOf<Car>()
        for (num in 1..number) {
            val car = Car(num)
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
