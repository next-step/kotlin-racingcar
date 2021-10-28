package racingcar.car

import racingcar.constant.Constant
import racingcar.engine.Engine

object CarFactory {
    fun initCarList(
        carCount: Int,
        engine: Engine
    ) = (Constant.START..carCount).map { Car(engine) }
}
