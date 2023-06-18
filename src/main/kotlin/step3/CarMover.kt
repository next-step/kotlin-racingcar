package step3

import kotlin.random.Random

class CarMover {

    fun move(carList: List<Car>) {
        carList.forEach{randomMove(it)}
    }

    /**
     * 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 각 자동차를 전진시킴
     */
    private fun randomMove(car: Car) {
        val randomNumber = Random.nextInt(MAX_BOUND)
        if (randomNumber >= FORWARD_NUMBER) car.move(DEFAULT_DISTANCE)
    }

    companion object {
        private const val DEFAULT_DISTANCE = 1
        private const val FORWARD_NUMBER: Int = 4
        private const val MAX_BOUND: Int = 10
    }
}