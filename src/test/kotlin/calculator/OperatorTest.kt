package calculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class OperatorTest : FreeSpec({

    "허용된 연산자를 변환한다." - {
        withData(
            nameFn = { "연산자(${it.first})" },
            "+" to Operator.PLUS,
            "-" to Operator.MINUS,
            "*" to Operator.MULTIPLY,
            "/" to Operator.DIVIDE
        ) { (input, expected) ->
            Operator.of(input) shouldBe expected
        }
    }

    "허용되지 않은 연산자는 변환할 수 없다." - {
        withData(
            nameFn = { "연산자($it)" },
            "", "&", "@", "#"
        ) { input ->
            val throws = assertThrows<IllegalArgumentException> { Operator.of(input) }
            throws.message.shouldContain(input)
        }
    }
})
