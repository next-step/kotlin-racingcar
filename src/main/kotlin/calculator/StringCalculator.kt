import java.util.StringTokenizer

var result = 0
fun calculator(str: String?): Int {
    if (str.isNullOrBlank()) {
        throw IllegalArgumentException("입력값이 null이거나 빈 공백입니다.")
    }

    val st = StringTokenizer(str)
    while (st.hasMoreTokens()) {
        when (val el = st.nextToken()) {
            "+" -> plus(st.nextToken())
            "-" -> minus(st.nextToken())
            "*" -> multiply(st.nextToken())
            "/" -> divide(st.nextToken())
            else -> result = parseInt(el)
        }
    }
    return result
}

private fun plus(el: String?) {
    result += parseInt(el)
}

private fun minus(el: String?) {
    result -= parseInt(el)
}

private fun multiply(el: String?) {
    result *= parseInt(el)
}

private fun divide(el: String?) {
    val num = parseInt(el)
    if (num == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
    result /= num
}

private fun parseInt(el: String?): Int {
    try {
        return Integer.parseInt(el)
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("숫자가 아닙니다.")
    }
}
