package racinggame.domain

object RandomEngineCarFactory : CarFactory {
    // Todo: 임시 name
    override fun create() = Car("", RandomEngine)
}
