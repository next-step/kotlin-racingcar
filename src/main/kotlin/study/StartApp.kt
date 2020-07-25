package study

fun main(args: Array<String>) {
    var inputValue: String
    do {
        try {
            println("구하고 싶은 식을 입력하세요")
            inputValue = readLine()!!
            if (inputValue == "null") {
                throw IllegalArgumentException("null을 입력하지마세요")
            }
            if (isBlank(inputValue)) {
                throw IllegalArgumentException("공백을 입력하지마세요")
            }
            break
        } catch (e: Exception) {
            println("오류가 발생했습니다. null값과 공백값을 입력하지 말아주세요")
        }
    } while (true)
    val strCal = StrCalculator(inputValue)
    val result = strCal.runCalculator()
    println(result)
}

fun isBlank(inputValue: String): Boolean {
    return inputValue.split(" ").none { it != "" }
}
