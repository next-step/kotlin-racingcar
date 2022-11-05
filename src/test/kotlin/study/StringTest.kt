package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class StringTest : StringSpec({
    "string to bigDecimal" {
        val bigDecimal1 = "10.2".toBigDecimalOrNull()
        val bigDecimal2 = "20.8".toBigDecimalOrNull()

        bigDecimal1 shouldBe BigDecimal.valueOf(10.2)
        bigDecimal2 shouldBe BigDecimal.valueOf(20.8)
        bigDecimal1?.add(bigDecimal2) shouldBe BigDecimal.valueOf(10.2 + 20.8)
    }
})
