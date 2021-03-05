package racing

fun printResult(carList: List<Car>) {
    println("실행 결과")

    carList.forEach {
        println("-".repeat(it.position))
    }
    println()
}
