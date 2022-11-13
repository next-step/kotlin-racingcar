package carracing.domain

object CarsFactory {
    fun of(count: Int): List<Car> {
        return (1..count).map { Car() }
    }
}
