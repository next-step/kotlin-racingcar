import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.LinkedList

class CalculatorOperatorTest {

    private val numberList = LinkedList<Int>()

    @BeforeEach
    fun setup() {
        numberList.run {
            add(99)
            add(33)
        }
    }

    @Test
    fun 더하기() {
        Assertions.assertThat(Calculator.calOperator(numList = numberList, operatorList = listOf('+'))).isEqualTo(132)
    }

    @Test
    fun 빼기() {
        Assertions.assertThat(Calculator.calOperator(numList = numberList, operatorList = listOf('-'))).isEqualTo(66)
    }
}
