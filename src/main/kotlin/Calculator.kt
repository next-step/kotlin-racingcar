import java.lang.IllegalArgumentException

class Calculator {
    fun calculate(args : String) : Number{
        if (args.isNullOrBlank()) throw IllegalArgumentException("") // todo

        var result = Number("0")
        var beforeNumber : Number = Number("0")
        var beforeOperator : Operator = Operator.add
        args.split(" ")
            .forEachIndexed { index, s ->
                if (index % 2 == 0) {
                    result = beforeNumber.operate(beforeOperator, Number(s))
                    beforeNumber = result
                } else if (index % 2 == 1) {
                    beforeOperator = Operator.of(s)
                }
            }
        return result
    }
}