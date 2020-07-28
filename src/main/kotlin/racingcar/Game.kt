package racingcar

class Game(private val carNum: Int, private var moveTime: Int) {
    private val cars = mutableListOf<Car>()

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

    fun isEndGame(): Boolean {
        return moveTime == 0
    }

    fun getCars(): List<Car> = cars

    fun getMoveTime(): Int = moveTime

    private fun randomValue(): Int = (0..9).random()
}
