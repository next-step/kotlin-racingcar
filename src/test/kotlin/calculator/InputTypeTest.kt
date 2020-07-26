package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InputTypeTest {

    @Test
    fun operator() {
        assertEquals(InputType.OPERATOR, InputType.of("+"))
        assertEquals(InputType.OPERATOR, InputType.of("-"))
        assertEquals(InputType.OPERATOR, InputType.of("*"))
        assertEquals(InputType.OPERATOR, InputType.of("/"))
    }

    @Test
    fun number() {
        assertEquals(InputType.NUMBER, InputType.of("43"))
    }

    @Test
    fun none() {
        assertEquals(InputType.NONE, InputType.of("x"))
        assertEquals(InputType.NONE, InputType.of("~"))
    }
}
