package step2

import java.lang.IllegalArgumentException

class FormulaList(private val formulaList: List<String>) {
    fun toSeparatedList(): Pair<List<Int>, List<Arithmetic>> {
        val numberList = mutableListOf<Int>()
        val arithmeticList = mutableListOf<Arithmetic>()
        formulaList.forEachIndexed { index, string ->
            val token = Token(index, string)
            if (token.isEven()) numberList.add(token.toNumber())
            else if (isLast(index)) throw IllegalArgumentException()
            else arithmeticList.add(token.toArithmetic())
        }

        return Pair(numberList, arithmeticList)
    }

    private fun isLast(index: Int) = index == formulaList.size - 1

}
