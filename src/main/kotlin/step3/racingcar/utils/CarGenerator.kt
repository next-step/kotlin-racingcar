package step3.racingcar.utils

import step3.racingcar.domain.Car
import step3.racingcar.domain.Cars

object CarGenerator {
    fun generate(carCount: Int): Cars =
        Cars(mutableListOf<Car>().also {
            for (i in 0 until carCount step 1) {
                it.add(Car())
            }
        })
}
