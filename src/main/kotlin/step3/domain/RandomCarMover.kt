package step3.domain

import kotlin.random.Random

class RandomCarMover : CarMover {

    /**
     * 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 각 자동차를 전진시킴
     */
    override fun movable(): Boolean {
        val randomNumber = Random.nextInt(MAX_BOUND)
        return randomNumber >= FORWARD_NUMBER
    }

    companion object {
        private const val FORWARD_NUMBER: Int = 4
        private const val MAX_BOUND: Int = 10
    }
}