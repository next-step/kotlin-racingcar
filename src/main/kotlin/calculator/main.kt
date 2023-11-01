package calculator

fun main() {
    print("input : ")
    var input: String? = readLine()

    val num = Calculator.calculate(input)
    println("계산 결과 : $num")
}
