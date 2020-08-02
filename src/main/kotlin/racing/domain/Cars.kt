package racing.domain

class Cars(private val cars: List<Car>) : List<Car> by cars {
    companion object {
        fun of(names: List<String>): Cars {
            return Cars(names.map { Car(it) })
        }
    }
}
