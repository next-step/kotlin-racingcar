package racinggame.domain.car

fun interface CarFactory {
    fun create(name: String): Car
}
