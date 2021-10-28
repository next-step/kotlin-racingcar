package racingcar.car

import racingcar.constant.Constant
import racingcar.engine.RandomEngine

object CarFactory {
    private val engine = RandomEngine()

    fun initCarList(carCount: Int) = (Constant.START..carCount).map { Car(engine) }
}
