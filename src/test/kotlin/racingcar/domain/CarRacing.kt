package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import racingcar.domain.CarFixture.initCars
import racingcar.domain.CarFixture.runningCars

class CarRacingTest: AnnotationSpec() {
    @Test
    fun `자동차 수 만큼 Car 객체가 생성되고 각 시작 위치는 0이다`() {
        val carCount = 3
        val resultCars = CarRacing.initCars(carCount)
        resultCars.size shouldBe carCount
        initCars[0].position shouldBe resultCars[0].position
        initCars[1].position shouldBe resultCars[1].position
        initCars[2].position shouldBe resultCars[2].position
    }

    @Test
    fun `자동차 경주 한 턴당 각 자동차 위치는 1칸 전진하거나 이동하지 않아야 한다`() {
        val resultCars = CarRacing.moveCars(runningCars)
        resultCars.size shouldBe runningCars.size
        resultCars[0].position shouldBeInRange runningCars[0].position..runningCars[0].position.plus(1)
        resultCars[1].position shouldBeInRange runningCars[1].position..runningCars[1].position.plus(1)
        resultCars[2].position shouldBeInRange runningCars[2].position..runningCars[2].position.plus(1)
    }
}