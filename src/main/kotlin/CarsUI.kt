class CarsUI(
    val cars: MutableList<Car>,
) {

    fun draw() {
        for (i in 0 until cars.size) {
            for (j in 0 until cars[i].moveCount) {
                print("-")
            }
            println()
        }

        println()
    }
}
