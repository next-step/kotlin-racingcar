package racinggame.domain.car

import racinggame.domain.engine.RandomEngine

object RandomEngineCarFactory : CarFactory {
    override fun create(name: String) = Car(name, RandomEngine)
}
