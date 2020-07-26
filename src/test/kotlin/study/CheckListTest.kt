package study

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class CheckListTest {

    @Test
    fun check_list() {
        val checkList = CheckList
        val numList = listOf("1", "2", "3")
        val symbolList = listOf("+", "-")
        val testNumList = mutableListOf<Int>(1, 2, 3)
        val testSymbolList = listOf("+", "-")

        val checkNumList = checkList.checkNumList(numList)
        val checkSymbolList = checkList.checkSymbolList(symbolList)

        assertThat(checkNumList).isEqualTo(testNumList)
        assertThat(checkSymbolList).isEqualTo(testSymbolList)
        assertThat(checkList.checkCouple(checkNumList, checkSymbolList)).isTrue()
    }

    @Test
    fun check_num_list_error() {
        val checkList = CheckList
        val numList = listOf("1", "2", "a")

        assertThatThrownBy {
            checkList.checkNumList(numList)
        }.isInstanceOf(NumberFormatException::class.java).hasMessageContaining("숫자가 아닌 값이 있습니다")
    }

    @Test
    fun check_symbol_list_error() {
        val checkList = CheckList
        val symbolList = listOf("+", "a")

        assertThatThrownBy {
            checkList.checkSymbolList(symbolList)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("사칙연산이 아닌 문자가 있습니다")
    }
}
