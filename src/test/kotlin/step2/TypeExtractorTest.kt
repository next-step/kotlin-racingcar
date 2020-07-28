package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import step2.TypeExtractor.mappingOperator

class TypeExtractorTest {

    @Test
    fun `Extract number test - single number`() {
        Assertions.assertThat(TypeExtractor.extractNumber("1")).isEqualTo(listOf(1))
    }

    @Test
    fun `Extract number test - multiple number`() {
        Assertions.assertThat(TypeExtractor.extractNumber("1111")).isEqualTo(listOf(1111))
    }

    @Test
    fun `Extract number test - single number & character`() {
        Assertions.assertThat(TypeExtractor.extractNumber("a1")).isEqualTo(listOf(1))
        Assertions.assertThat(TypeExtractor.extractNumber("1a")).isEqualTo(listOf(1))
    }

    @Test
    fun `Extract number test - character precedes the number`() {
        Assertions.assertThat(TypeExtractor.extractNumber("aa10bb20cc30")).satisfies {
            Assertions.assertThat(it.size).isEqualTo(3)
            Assertions.assertThat(it).isEqualTo(listOf(10, 20, 30))
        }
    }

    @Test
    fun `Extract number test - number precedes the character`() {
        Assertions.assertThat(TypeExtractor.extractNumber("10aa20bb30cc")).satisfies {
            Assertions.assertThat(it.size).isEqualTo(3)
            Assertions.assertThat(it).isEqualTo(listOf(10, 20, 30))
        }
    }

    @Test
    fun `Extract Operator test - single operator`() {
        Assertions.assertThat(TypeExtractor.extractOperator("+")).isEqualTo(listOf("+"))
        Assertions.assertThat(TypeExtractor.extractOperator("-")).isEqualTo(listOf("-"))
        Assertions.assertThat(TypeExtractor.extractOperator("*")).isEqualTo(listOf("*"))
        Assertions.assertThat(TypeExtractor.extractOperator("/")).isEqualTo(listOf("/"))
        Assertions.assertThat(TypeExtractor.extractOperator("?")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `Extract Operator test - multiple operator`() {
        Assertions.assertThat(TypeExtractor.extractOperator("++++++")).isEqualTo(listOf("+", "+", "+", "+", "+", "+"))
        Assertions.assertThat(TypeExtractor.extractOperator("??????")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `Extract Operator test - single operator & character`() {
        Assertions.assertThat(TypeExtractor.extractOperator("1*")).isEqualTo(listOf("*"))
        Assertions.assertThat(TypeExtractor.extractOperator("*1")).isEqualTo(listOf("*"))
        Assertions.assertThat(TypeExtractor.extractOperator("11")).isEqualTo(emptyList<String>())
    }

    @Test
    fun `Extract Operator test - multiple operator * character`() {
        Assertions.assertThat(TypeExtractor.extractOperator("1**3*4*5")).satisfies {
            Assertions.assertThat(it.size).isEqualTo(4)
            Assertions.assertThat(it).isEqualTo(listOf("*", "*", "*", "*"))
        }
        Assertions.assertThat(TypeExtractor.extractOperator("*1-2+3//5")).satisfies {
            Assertions.assertThat(it.size).isEqualTo(5)
            Assertions.assertThat(it).isEqualTo(listOf("*", "-", "+", "/", "/"))
        }
    }

    @Test
    fun `Valid expression`() {
        Assertions.assertThat(TypeExtractor.extract("1*2*3*4*5")).satisfies {
            Assertions.assertThat(it.first).isEqualTo(listOf(1, 2, 3, 4, 5))
            Assertions.assertThat(it.second).isEqualTo(listOf(Operator.MUL, Operator.MUL, Operator.MUL, Operator.MUL))
        }

        Assertions.assertThat(TypeExtractor.extract("11+2/3*4-5")).satisfies {
            Assertions.assertThat(it.first).isEqualTo(listOf(11, 2, 3, 4, 5))
            Assertions.assertThat(it.second).isEqualTo(listOf(Operator.ADD, Operator.DIV, Operator.MUL, Operator.SUB))
        }
    }

    @Test
    fun `Invalid expression`() {
        Assertions.assertThatThrownBy { TypeExtractor.extract("*1*2*3*4*5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")

        Assertions.assertThatThrownBy { TypeExtractor.extract("1**2*3*4*5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")

        Assertions.assertThatThrownBy { TypeExtractor.extract("1*2*3*4**5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")

        Assertions.assertThatThrownBy { TypeExtractor.extract("/1++2-3/4**5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")
    }

    @Test
    fun `Empty expression`() {
        Assertions.assertThatThrownBy { TypeExtractor.extract("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")

        Assertions.assertThatThrownBy { TypeExtractor.extract("11") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")

        Assertions.assertThatThrownBy { TypeExtractor.extract("+") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")
    }

    @Test
    fun `Mapping Operator enum class`() {
        Assertions.assertThat(listOf("+", "-", "*", "/").mappingOperator())
            .isEqualTo(listOf(Operator.ADD, Operator.SUB, Operator.MUL, Operator.DIV))

        Assertions.assertThatThrownBy { listOf("-", "-", "-", "0").mappingOperator() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Invalid operator type")
    }

}