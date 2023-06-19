package study.racing.car.factory

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldNotBe

internal class NameBasedCarListFactoryTest : StringSpec({
    "차량들의 이름들을 기반으로 차량 객체들을 생성한다" {
        val carNames = listOf("A", "B")
        val sut = NameBasedCarListFactory(carNames)
        val carList = sut.create()
        carNames.forEach { carName ->
            carList.find { it.name == carName } shouldNotBe null
        }
    }
})
