class Calculator {
    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun calc(input: String): Int {
        var prevNumber = 0
        var expression = "+"
        var result = 0

        for (s in input) {
            if (isInteger(s.toString())) {
                prevNumber = s.toString().toInt()
                if (expression == "+") {
                    result = add(prevNumber, result)
                }
                continue
            }
            if (s.toString() == " ") {
                continue
            }
            expression = s.toString()
        }
        return result
    }
}


fun isInteger(string: String): Boolean {
    return string.toIntOrNull() != null
}
