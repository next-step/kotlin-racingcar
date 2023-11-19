package racing

data class Cars(val carList: List<Car>) {
    val winner: List<Car>
        get() = run {
            val maxRoute = carList.maxOf { it.route }
            carList.filter { it.route == maxRoute }
        }
}
