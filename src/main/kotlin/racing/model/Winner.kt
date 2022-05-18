package racing.model

class Winner(private val cars: Cars) {

    fun names(separator: String = ", "): String =
        cars
            .maxAll()
            .map(Car::name)
            .joinToString(separator)
}
