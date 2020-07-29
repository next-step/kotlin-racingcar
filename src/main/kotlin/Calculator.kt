private const val SPLIT_FORMAT = " "

class Calculator {
    fun calculate(arr: List<String>): Double {
        try {
            var value = arr[0].toDouble()
            for (i in 1 until arr.size step 2) {
                if (i + 1 >= arr.size) break
                value = Operate.generate(arr[i]).calc(value, arr[i + 1].toDouble())
            }
            return value
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자 형식이 잘못 되었습니다. / ${e.message}")
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("연산자는(+,-,*,/)를 지원 합니다. / ${e.message}")
        }
    }
}

fun main() {
    val calculator = Calculator()

    print("input:")
    val input = readLine()!!.split(SPLIT_FORMAT).map { it.trim() }
    val output = calculator.calculate(input)

    println(output)
}
