package step3.domain

import step3.model.Car

object RandomEngineCarFactory : CarFactory {
    override fun create() = Car(RandomEngine)
}