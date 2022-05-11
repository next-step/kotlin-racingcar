package racinggame.domain.car

import racinggame.domain.engine.RandomEngine

object RandomEngineCarFactory : CarFactory {
    // Todo: 임시 name
    override fun create() = Car("", RandomEngine)
}
