package study.racingcar.step4

import study.racingcar.step4.utils.RandomUtil

class RandomRunnable(private val ableValue: Int, private val randomMaxNumber: Int) : Runnable {

    override fun canRun(): Boolean {
        return ableValue <= RandomUtil.getRandomNumberByZeroToMax(randomMaxNumber)
    }

}