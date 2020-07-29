package racingcar

class Game(carNum: Int, moveTime: Int) {
    private val cars = mutableListOf<Car>()
    var moveTime = moveTime
        private set

    init {
        makeCars(carNum)
    }

    private fun makeCars(number: Int) {
        for (num in 1..number) {
            val car = Car(num)
            cars.add(car)
        }
    }

    fun race() {
        moveTime -= 1
        for (car in cars) {
            car.goStop(randomValue())
        }
    }

    fun isEndGame(): Boolean = moveTime == 0

    fun getCars(): List<Car> = cars

    private fun randomValue(): Int = (0..9).random()
}
