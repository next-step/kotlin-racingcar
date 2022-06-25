package racingcar.domain.record

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.movingStrategy

class RaceRecordTest : AnnotationSpec() {
    private val movingCars = List(3) {
        Car(
            movingStrategy
        )
    }

    @Test
    fun `RaceRecord는 모든 자동차들의 위치를 기억한다`() {
        // given
        val raceRecord = RaceRecord()
        val cars = Cars(movingCars)

        // when
        raceRecord.record(cars)
        cars.move()
        raceRecord.record(cars)

        // then
        raceRecord.record.size shouldBe 2
        raceRecord.record[0].positions.map { position ->
            position.value shouldBe 0
        }
        raceRecord.record[1].positions.map { position ->
            position.value shouldBe 1
        }
    }
}
