package step3

object OutPutView {
    fun printStart() {
        println("실행 결과")
    }

    fun printRound(cars: List<Car>) {
        cars.forEach { car -> println(makeBar(car.position)) }
        println()
    }

    private fun makeBar(position: Int): String {
        var sb = StringBuilder()
        repeat(position) {
            sb.append("-")
        }
        return sb.toString()
    }
}
