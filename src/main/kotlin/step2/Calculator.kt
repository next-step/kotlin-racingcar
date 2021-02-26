package step2

const val BLANK = " "

fun main() {
    val input = Input()
    val strFormula = input.inputFormula()
    val listFormula = input.convertFormulaToList(strFormula)

    println(listFormula.toString())

}

