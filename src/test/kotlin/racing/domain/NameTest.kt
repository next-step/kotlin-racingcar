package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class NameTest : FunSpec({
    test("Name.of() 은 5자 이하로만 생성할 수 있다.") {
        val name = "tester"
        shouldThrow<IllegalArgumentException> {
            Name.of(name)
        }
    }
})
