package calculator

import java.util.LinkedList
import java.util.Queue

class Calculator(
    private val convertor: Convertor = Convertor()
) {
    private val signs: Queue<MathematicalSign> = LinkedList()
    private val numbers: MutableList<Int> = mutableListOf()

    /**
     * (순서를 무시하는) 사칙연산 함수
     */
    fun arithmeticOperation(numberSentence: String?): Int {
        val inputList = convertor.splitNumberSentenceToList(numberSentence)

        inputList.forEachIndexed { index, input ->
            when (index % 2) {
                0 -> numbers.add(convertor.getNumber(input))
                1 -> signs.add(convertor.getMathematicalSigns(input))
            }
        }

        return numbers.reduce { total, number -> signs.poll().operation.invoke(total, number) }
    }
}
