package step3.domain

object RandomEngineCarFactory : CarFactory {
    override fun create() = Car(RandomEngine)
}