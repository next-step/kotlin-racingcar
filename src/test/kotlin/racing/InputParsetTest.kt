package racing

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldHaveSize

class InputParsetTest : AnnotationSpec() {

    @Test
    fun `자동차 이름은 쉼표로 구분함`() {
        val carNames = "pobi,crong,honux"
        InputParser.parse(carNames) shouldHaveSize(3)
    }
}
