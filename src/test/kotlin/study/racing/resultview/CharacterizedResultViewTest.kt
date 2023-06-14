package study.racing.resultview

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.racing.car.Car
import study.racing.renderer.Renderer

internal class CharacterizedResultViewTest : StringSpec({

    "차량의 이름을 출력하고 총 이동거리를 주어진 문자를 반복하여 표현한다"() {
        val mirror = mutableListOf<String>()
        val sut = CarNameDisplayedResultView("-", InputMirroringRenderer(mirror))
        sut.printResult(listOf(Car(name = "차량1", 3)))
        val actual = mirror.joinToString(separator = "\n")
        val expected = "차량1: ---\n"
        actual shouldBe expected
    }
}) {
    class InputMirroringRenderer(private val mirror: MutableList<String>) : Renderer {
        override fun render(element: Any?) {
            mirror.add(element as String)
        }
    }
}
