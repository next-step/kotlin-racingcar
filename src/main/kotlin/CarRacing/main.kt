package CarRacing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount: String? = readLine()
    println("시도할 횟수는 몇 회인가요?")
    val movementTryCount:String? = readLine()

    println("carCount:" + carCount.toString())
    println("carCount:" + movementTryCount.toString())
}