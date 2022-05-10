package racinggame.domain

object RandomEngineCarFactory : CarFactory {
    override fun create() = Car(RandomEngine)
}
