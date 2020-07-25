import java.lang.NumberFormatException

class Calculator {
    fun calc(arr: List<String>): Double {
        try {
            var value = Integer.parseInt(arr[0]).toDouble()
            for (i in 1 until arr.size step 2) {
                if (i + 1 >= arr.size) break
                value = Operate.generate(arr[i]).calc(value, Integer.parseInt(arr[i + 1]).toDouble())
            }
            return value
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자 형식이 잘못 되었습니다.")
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("연산자 타입이 잘못 되었습니다.")
        }
    }
}

fun main() {
    val calculator = Calculator()

    print("input:")
    val input = readLine()!!.split(" ").map { it.trim() }
    val output = calculator.calc(input)

    println(output)
}
