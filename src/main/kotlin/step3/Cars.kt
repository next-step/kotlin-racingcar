package step3

class Cars(val cars: List<Car>) {
    fun size() = cars.size

    operator fun get(i: Int) = cars[i]

    companion object {
        fun fromNames(names: String): Cars {
            return Cars(names.split(",").map { Car(it) })
        }
    }
}
