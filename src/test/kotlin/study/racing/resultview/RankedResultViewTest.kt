package study.racing.resultview

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racing.car.Car

internal class RankedResultViewTest : StringSpec({
    "우승 차량들을 입력으로 받아서 적절한 메시지를 표출한다" {
        val mirror = mutableListOf<String>()
        val sut = RankedResultView(InputMirroringRenderer(mirror))
        sut.printResult(listOf(Car(name = "차량1", 3)))
        val actual = mirror.joinToString(separator = "\n")
        val expected = "차량1 가 최종 우승했습니다."
        actual shouldBe expected
    }
})
