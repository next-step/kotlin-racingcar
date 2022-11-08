package racingcar

fun main() {
    val randomNumberRange = 0..9
    val inputView = InputView()

    println("자동차 대수는 몇 대인가요?")
    val carNumber = inputView.input()

    val carList = mutableListOf<Car>()
    for (i in 1..carNumber) {
        carList.add(Car())
    }

    println("시도할 횟수는 몇 회인가요?")
    val count = inputView.input()
    for (i in 1..count) {
        carList.forEach {
            it.move((randomNumberRange).random())
            print(makeResult(it.status))
        }
        println()
    }


}
fun makeResult(number: Int) : String{
    val str : StringBuilder = StringBuilder()
    for (i in 1..number) {
        str.append("-")
    }
    str.append("\n")
    return str.toString()
}