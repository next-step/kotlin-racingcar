package step2

class Calculator {
    fun calculate(inp1utString: String): String {
        val splitList = inp1utString.split(" ")
        return splitList
            .mapNotNull { it.toIntOrNull() }
            .sumOf { it }
            .toString()
    }
}
