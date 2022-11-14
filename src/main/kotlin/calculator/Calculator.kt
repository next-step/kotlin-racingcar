package calculator

class Calculator(private val operator: Operator) {
    fun calculate(s: String): Int {
        val (opd, opt) = parse(s)

        var result = opd[0]
        for (i in 0..opd.size - 2) {
            operator.find(opt[i])
            result = operator.operate(result, opd[i + 1])
        }

        return result
    }

    private fun parse(s: String): Pair<List<Int>, List<Char>> {
        val opd = mutableListOf<Int>()
        val opt = mutableListOf<Char>()

        val token = s.split(" ")
        token.forEach { t ->
            if (isInt(t)) opd.add(t.toInt())
            else opt.add(t.first())
        }

        return opd to opt
    }

    private fun isInt(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
