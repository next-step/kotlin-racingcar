package racingcar.car

import racingcar.engine.Engine
import racingcar.util.Validation

object CarFactory {
    fun initCarList(
        carsName: String,
        engine: Engine
    ) = carsName.split(Validation.DELIMITER).map { Car(engine, it) }
}
