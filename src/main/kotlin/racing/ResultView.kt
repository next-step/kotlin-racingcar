package racing

fun printResult(carList: List<Car>) {
    println("실행 결과")

    carList.forEach {
        (0 until it.position).forEach {
            print("-")
        }
        println("")
    }
    println("")
}
