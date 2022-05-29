package study.step1

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringKoTest : AnnotationSpec(){

    @AnnotationSpec.Test
    fun isEmpty(){
        "".isEmpty() shouldBe true
        " ".isEmpty() shouldBe false
        "a".isEmpty() shouldBe false
    }
}