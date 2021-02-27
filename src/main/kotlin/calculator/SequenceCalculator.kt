package calculator

class SequenceCalculator : Calculator {
    private val numbers = mutableListOf<Number>()
    private val operators = mutableListOf<Operator>()
    private var result = Number.of("0")

    override fun parse(line: String) {
        line.split(" ")
            .map {
                add(it)
            }
    }

    private fun add(value: String) {
        if (value in Operator.operators) {
            operators.add(Operator.of(value))
            return
        }
        numbers.add(Number.of(value))
    }

    override fun calculate() {
        var result = numbers.removeAt(0)
        var op = operators.removeAt(0)

        while (numbers.isNotEmpty()) {
            val num = numbers.removeAt(0)
            result = op.operation(result, num)
            if (operators.isNotEmpty()) {
                op = operators.removeAt(0)
            }
        }
        this.result = result
    }

    override fun result(): Number {
        return result
    }
}
