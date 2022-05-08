package calculator

class Calculator {
    fun groupByIsNumber(inputs: List<String>, bool: Boolean): List<String> {
        val elements = inputs.groupBy { (it.toDoubleOrNull() != null) };
        return elements[bool]!!
    }

    fun calculate(input: String): Int {
        val inputs = input.split(" ");
        val numbers = groupByIsNumber(inputs, true)
        val operations = groupByIsNumber(inputs, false);

        var total = numbers[0].toInt();

        for ((index, el) in numbers.drop(1).withIndex()) {
            if (operations[index] == "+") {
                total += el.toInt();
            }
            if (operations[index] == "-") {
                total -= el.toInt();
            }
            if (operations[index] == "*") {
                total *= el.toInt();
            }
        }

        return total
    }
}