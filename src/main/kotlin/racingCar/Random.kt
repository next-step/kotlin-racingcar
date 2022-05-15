package racingCar

import java.util.Random

interface IRandom {
    fun generate(): Int
}

class Random: IRandom {
    override fun generate(): Int = Random().nextInt(10)
}