package calculator

val calculateResult = { input: String ->
    var operator = Operator.PLUS
    input.split(" ").withIndex().fold(0.0) { acc, (index, item) ->
        var result = acc
        if (isEvenAndDigit(item, index))
            result = Operator.operate(operator, acc, item.toDouble())
        else if (isOddAndOperator(item, index))
            operator = Operator.fromValue(item)!!
        result
    }
}

fun calculate(input: String?) = validateInput(input)!!.let(calculateResult).let(::println)
