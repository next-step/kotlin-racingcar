package study

import io.kotest.core.spec.style.FunSpec
import org.assertj.core.api.Assertions

class FunSpecTest : FunSpec({
    test("test") {
        Assertions.assertThat("").isEmpty()
        Assertions.assertThat(" ").isNotEmpty
        Assertions.assertThat("a").isNotEmpty()
    }

    test("subString") {
        val phoneNumber = "010-8802-5013"
        Assertions.assertThat(phoneNumber.substringBefore("-")).isEqualTo("010")
        Assertions.assertThat(phoneNumber.substringBeforeLast("-")).isEqualTo("010-8802")
        Assertions.assertThat(phoneNumber.substringAfter("-")).isEqualTo("8802-5013")
        Assertions.assertThat(phoneNumber.substringAfterLast("-")).isEqualTo("5013")
    }
})
