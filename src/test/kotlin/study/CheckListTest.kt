package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CheckListTest {

    @Test
    fun check_list() {
        val checkList = CheckList()
        val numList = listOf("1", "2", "3")
        val symbolList = listOf("+", "-")
        val testNumList = mutableListOf<Int>(1, 2, 3)
        val testSymbolList = listOf("+", "-")

        val checkNumList = checkList.checkNumList(numList)
        val checkSymbolList = checkList.checkSymbolList(symbolList)

        Assertions.assertThat(checkNumList).isEqualTo(testNumList)
        Assertions.assertThat(checkSymbolList).isEqualTo(testSymbolList)
        Assertions.assertThat(checkList.checkCouple(checkNumList, checkSymbolList)).isTrue()
    }

    @Test
    fun check_num_list_error() {
        val checkList = CheckList()
        val numList = listOf("1", "2", "a")

        try {
            checkList.checkNumList(numList)
        } catch (e: Exception) {
            Assertions.assertThat(e.message).isEqualTo("숫자가 아닌 값이 있습니다")
        }
    }

    @Test
    fun check_symbol_list_error() {
        val checkList = CheckList()
        val symbolList = listOf("+", "a")

        try {
            checkList.checkSymbolList(symbolList)
        } catch (e: Exception) {
            Assertions.assertThat(e.message).isEqualTo("사칙연산이 아닌 문자가 있습니다")
        }
    }
}
