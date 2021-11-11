package racingcar.domain.car

import racingcar.domain.car.engine.Engine
import racingcar.util.Validation

object CarFactory {
    fun initCarList(
        carsName: String,
        engine: Engine
    ) = carsName.split(Validation.DELIMITER).map { Car(engine, it) }
}
