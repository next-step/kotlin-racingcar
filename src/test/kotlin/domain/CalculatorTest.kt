package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException

internal class CalculatorTest {
    @Test
    fun `덧셈_테스트`() {
        assertAll(
            { assertEquals(10.0, Calculator().calculate(CalculationExpression("1 + 2 + 3 + 4"))) },
            { assertEquals(-8.0, Calculator().calculate(CalculationExpression("-14 + 2 + 0 + 4"))) },
            { assertEquals(3.5, Calculator().calculate(CalculationExpression("-1 + 2.5 + -2 + 4"))) }
        )
    }

    @Test
    fun `뺄셈_테스트`() {
        assertAll(
            { assertEquals(-8.0, Calculator().calculate(CalculationExpression("1 - 2 - 3 - 4"))) },
            { assertEquals(12.0, Calculator().calculate(CalculationExpression("4 - -12 - 0 - 4"))) },
            { assertEquals(-10.5, Calculator().calculate(CalculationExpression("-1 - 2 - 3.5 - 4"))) }
        )
    }

    @Test
    fun `나눗셈_테스트`() {
        assertAll(
            { assertEquals(1.0, Calculator().calculate(CalculationExpression("-15 / 3 / -5"))) },
            { assertEquals(3.33, Calculator().calculate(CalculationExpression("10 / 3"))) },
            { assertEquals(0.5, Calculator().calculate(CalculationExpression("1 / 2"))) }
        )
    }

    @Test
    fun `곱셈_테스트`() {
        assertAll(
            { assertEquals(225.0, Calculator().calculate(CalculationExpression("-15 * 3 * -5"))) },
            { assertEquals(30.3, Calculator().calculate(CalculationExpression("10.1 * 3"))) },
            { assertEquals(20.0, Calculator().calculate(CalculationExpression("100 * 0.2"))) }
        )
    }

    @Test
    fun `혼합_계산_테스트`() {
        assertAll(
            { assertEquals(0.0, Calculator().calculate(CalculationExpression("-15 + 3 - -5 + 7"))) },
            { assertEquals(0.0, Calculator().calculate(CalculationExpression("10 - 10 * 0 / 100"))) },
            { assertEquals(52.6, Calculator().calculate(CalculationExpression("100 * 0.2 / 1.0 + 32.6"))) }
        )
    }

    @Test
    fun `나눗셈_0으로_나눔_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("1 / 0")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("1.1 / 0")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("10 / 0")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("12.3 / 0")))
                }
            }
        )
    }

    @Test
    fun `처음_입력이_연산자일_경우_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("- 1 + 1")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("/ 1.1 -")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("+ 10 /")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("* 12.3 * 1")))
                }
            }
        )
    }

    @Test
    fun `마지막_입력이_연산자일_경우_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("1 +")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("1.1 -")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("10 /")))
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    assertEquals(-18.0, Calculator().calculate(CalculationExpression("12.3 *")))
                }
            }
        )
    }
}
