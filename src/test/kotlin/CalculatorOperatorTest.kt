import org.junit.jupiter.api.BeforeEach
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
}
