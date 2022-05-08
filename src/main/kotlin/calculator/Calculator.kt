package calculator

class Calculator {
    fun calculate (input: String): Int {
        val inputs = input.split(" ");
        var total = 0;

        for((index, el) in inputs.withIndex())
            if(index % 2 == 0) {
                total += el.toInt();
            }

        return total
    }
}