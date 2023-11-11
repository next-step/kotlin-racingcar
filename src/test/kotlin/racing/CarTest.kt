package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.domain.Car
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
})
