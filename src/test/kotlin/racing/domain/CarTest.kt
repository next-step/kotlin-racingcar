package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class CarTest : FunSpec({
    test("자동차는 이름을 가진다") {
        forAll(
            row("Jiwon"),
            row("Alex")
        ) { name ->
            val car = Car(name)
            car.name shouldBe name
        }
    }

    test("자동차의 이름은 5자를 초과하면 예외가 발생") {
        shouldThrow<IllegalArgumentException> {
            Car("Jiwon Kwon")
        }
    }

    test("자동차는 전진한다") {
        // Given
        val car = Car("Jiwon")

        // When
        car.move()

        // Then
        car.position shouldBe 1
    }

    test("제일 빠른 위치에 있는지 확인") {
        // Given
        val car1 = Car("Bob", 3)
        val car2 = Car("jibob", 5)
        val carList = listOf(car1, car2)

        // When
        val fastestPosition = carList.maxBy { it.position }.position

        // Then
        fastestPosition shouldBe 5
        car1.isEqualToPosition(fastestPosition) shouldBe false
        car2.isEqualToPosition(fastestPosition) shouldBe true
    }
})
