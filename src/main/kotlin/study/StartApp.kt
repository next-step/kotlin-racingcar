package study

fun main(args: Array<String>) {
    println("구하고 싶은 식을 입력하세요")
    val inputValue = readLine()!!
    val calculator = StrCalculator(inputValue)
    val result = calculator.play()
    println(result)
}
