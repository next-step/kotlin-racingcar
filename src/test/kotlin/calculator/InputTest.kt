package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import org.junit.jupiter.api.assertThrows

class InputTest : FunSpec({

    context("입력값은 공백일 수 없다.") {
        withData(
            nameFn = { "입력값 - $it" },
            null, "", " "
        ) { input ->
            assertThrows<IllegalArgumentException> {
                Input(input)
            }
        }
    }
})
