package racingcar

object CarManager {
    private val carList = mutableListOf<Car>()

    fun createCarList(num: Int) {
        for (i in 0 until num) {
            carList.add(Car())
        }
    }

    fun moveCar(index: Int, isMove: Boolean) {
        if (isMove) {
            carList[index].move()
        }
    }

    fun getCarPosition(index: Int) = carList[index].position
}
