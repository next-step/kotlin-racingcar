package step3

import kotlin.random.Random

object CarMover {

    fun move(carList: List<MutableList<String>>) {
        carList.forEach{randomMove(it)}
    }

    /**
     * 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 각 자동차를 전진시킴
     */
    private fun randomMove(car: MutableList<String>) {
        val randomNumber = Random.nextInt(10)
        if (randomNumber >= 4) car += "-"
    }
}