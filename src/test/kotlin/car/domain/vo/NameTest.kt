package car.domain.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class NameTest: StringSpec({
    "이름을 생성할수 있다" {
        names.forAll { shouldNotThrow<Throwable> { Name(it) } }
    }

    "이름이 비어있는 경우 Exception을 던진다." {
        shouldThrow<IllegalArgumentException> { Name("") }
    }
}) {
    companion object {
        private val names = listOf("A", "AB", "ABC")
    }
}
