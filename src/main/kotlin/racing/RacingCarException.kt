package racing

sealed class RacingCarException(message: String) : RuntimeException(message)

class CarNameException(message: String) : RacingCarException(message)
class PositionException(message: String) : RacingCarException(message)
class RoundException(message: String) : RacingCarException(message)
class CarsException(message: String) : RacingCarException(message)

fun require(value: Boolean, lazyThrowable: () -> Throwable) {
    if (!value) {
        throw lazyThrowable()
    }
}
