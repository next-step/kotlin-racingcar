package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe


class StringTest: AnnotationSpec() {

  @Test
  fun isEmpty() {
    "".isEmpty() shouldBe true
    "".isEmpty() shouldBe true
    "".isEmpty() shouldBe true
  }


}