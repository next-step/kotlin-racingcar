package study

fun main(args: Array<String>) {
    do {
        try {
            println("구하고 싶은 식을 입력하세요")
            val inputValue = readLine()!!
            if (inputValue == "null") {
                throw IllegalArgumentException("null을 입력하지마세요")
            }
            if (isBlank(inputValue)) {
                throw IllegalArgumentException("공백을 입력하지마세요")
            }
            val strCal = StrCalculator(inputValue)
            val result = strCal.runCalculator()
            println(result)
            break
        } catch (e: Exception) {
            println(e.message)
        }
    } while (true)
}

fun isBlank(inputValue: String): Boolean {
    return inputValue.split(" ").none { it != "" }
}
