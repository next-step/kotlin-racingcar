package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class NameTest : StringSpec({

    "자동차의 이름은 비어있을 수 없다" {
        listOf(
            "",
            " ",
            "  ",
        ).forEach { emptyName ->
            shouldThrow<IllegalArgumentException> {
                Name(emptyName)
            }
        }
    }
})
