package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import step2.TypeExtractor.mappingOperator

class TypeExtractorTest {

    @Test
    fun `Extract number test - single number`() {
        assertThat(TypeExtractor.extractNumber("1")).isEqualTo(listOf(1))
    }

    @Test
    fun `Extract number test - multiple number`() {
        assertThat(TypeExtractor.extractNumber("1111")).isEqualTo(listOf(1111))
    }

    @Test
    fun `Extract number test - single number & character`() {
        assertThat(TypeExtractor.extractNumber("a1")).isEqualTo(listOf(1))
        assertThat(TypeExtractor.extractNumber("1a")).isEqualTo(listOf(1))
    }

    @Test
    fun `Extract number test - character precedes the number`() {
        assertThat(TypeExtractor.extractNumber("aa10bb20cc30")).satisfies {
            assertThat(it.size).isEqualTo(3)
            assertThat(it).isEqualTo(listOf(10, 20, 30))
        }
    }

    @Test
    fun `Extract number test - number precedes the character`() {
        assertThat(TypeExtractor.extractNumber("10aa20bb30cc")).satisfies {
            assertThat(it.size).isEqualTo(3)
            assertThat(it).isEqualTo(listOf(10, 20, 30))
        }
    }

    @Test
    fun `Extract Operator test - single operator`() {
        assertThat(TypeExtractor.extractOperator("+")).isEqualTo(listOf("+"))
        assertThat(TypeExtractor.extractOperator("-")).isEqualTo(listOf("-"))
        assertThat(TypeExtractor.extractOperator("*")).isEqualTo(listOf("*"))
        assertThat(TypeExtractor.extractOperator("/")).isEqualTo(listOf("/"))
        assertThat(TypeExtractor.extractOperator("?")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `Extract Operator test - multiple operator`() {
        assertThat(TypeExtractor.extractOperator("++++++")).isEqualTo(listOf("+", "+", "+", "+", "+", "+"))
        assertThat(TypeExtractor.extractOperator("??????")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `Extract Operator test - single operator & character`() {
        assertThat(TypeExtractor.extractOperator("1*")).isEqualTo(listOf("*"))
        assertThat(TypeExtractor.extractOperator("*1")).isEqualTo(listOf("*"))
        assertThat(TypeExtractor.extractOperator("11")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `Extract Operator test - multiple operator * character`() {
        assertThat(TypeExtractor.extractOperator("1**3*4*5")).satisfies {
            assertThat(it.size).isEqualTo(4)
            assertThat(it).isEqualTo(listOf("*", "*", "*", "*"))
        }
        assertThat(TypeExtractor.extractOperator("*1-2+3//5")).satisfies {
            assertThat(it.size).isEqualTo(5)
            assertThat(it).isEqualTo(listOf("*", "-", "+", "/", "/"))
        }
    }

    @Test
    fun `Valid expression`() {
        assertThat(TypeExtractor.extract("1*2*3*4*5")).satisfies {
            assertThat(it.first).isEqualTo(listOf(1, 2, 3, 4, 5))
            assertThat(it.second).isEqualTo(listOf(Operator.MUL, Operator.MUL, Operator.MUL, Operator.MUL))
        }

        assertThat(TypeExtractor.extract("11+2/3*4-5")).satisfies {
            assertThat(it.first).isEqualTo(listOf(11, 2, 3, 4, 5))
            assertThat(it.second).isEqualTo(listOf(Operator.ADD, Operator.DIV, Operator.MUL, Operator.SUB))
        }
    }

    @Test
    fun `Invalid expression`() {
        assertThatThrownBy { TypeExtractor.extract("*1*2*3*4*5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")

        assertThatThrownBy { TypeExtractor.extract("1**2*3*4*5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")

        assertThatThrownBy { TypeExtractor.extract("1*2*3*4**5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")

        assertThatThrownBy { TypeExtractor.extract("/1++2-3/4**5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")
    }

    @Test
    fun `Empty expression`() {
        assertThatThrownBy { TypeExtractor.extract("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")

        assertThatThrownBy { TypeExtractor.extract("11") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")

        assertThatThrownBy { TypeExtractor.extract("+") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")
    }

    @Test
    fun `Mapping Operator enum class`() {
        assertThat(listOf("+", "-", "*", "/").mappingOperator())
            .isEqualTo(listOf(Operator.ADD, Operator.SUB, Operator.MUL, Operator.DIV))

        assertThatThrownBy { listOf("-", "-", "-", "0").mappingOperator() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Invalid operator type")
    }

}