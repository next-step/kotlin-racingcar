class CarRacing(
    val carNumber: Int = 0,
    val tryNumber: Int = 0,
) {
    fun start() {
        println("자동차 대수는 몇 대인가요?")
        val carNumber = readLine()!!.toInt()
        println("시도할 회수는 몇 회인가요?")
        val tryNumber = readLine()!!.toInt()

        val cars = MutableList(carNumber) { Car() }
        for (i in 0 until tryNumber) {
            for (j in 0 until carNumber) {
                cars[j].move()
            }

            CarsUI(cars).draw()
        }
    }
}

fun main() {
    CarRacing().start()
}
