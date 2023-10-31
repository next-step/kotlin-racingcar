package racing.car

import racing.rule.Rule

object CarManager {
    private val carList = mutableListOf<Car>()
    private val rule = Rule()
    fun createCarList(num: Int) {
        for (i in 0 until num) {
            carList.add(Car())
        }
    }

    fun moveCar() {
        carList.forEach { if (rule.isMove()) it.move() }
    }

    fun getCarPositionList(): List<Int> {
        val carPositionList = mutableListOf<Int>()

        carList.map { carPositionList.add(it.position) }

        return carPositionList
    }
}
