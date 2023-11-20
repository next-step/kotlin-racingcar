package racing.domain

data class Cars(val cars: List<Car>) {
    val winner: List<Car>
        get() = run {
            val maxRoute = cars.maxOf { it.route }
            cars.filter { it.route == maxRoute }
        }
}
