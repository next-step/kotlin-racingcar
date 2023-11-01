package racing.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest : BehaviorSpec() {

    @ValueSource(strings = ["pobi", "crong", "honux"])
    @ParameterizedTest
    fun `자동차는 이름을 가진다`(name: String) {
        val car = Car(name)
        car.name shouldBe name
    }

    @Test
    fun `자동차의 이름이 5자를 초과하면 예외가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 5자를 초과할 수 없습니다.") {
            Car("pobicronghonux")
        }
    }

    @Test
    fun `자동차의 초기 위치는 1이다`() {
        val car = Car("pobi")
        car.position shouldBe 1
    }

    @Test
    fun `자동차는 위치를 가진다`() {
        val car = Car("pobi", _position = 10)
        car.position shouldBe 10
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `자동차는 무작위 값이 4 이상일 경우 움직인다`(condition: Int) {
        given("자동차는") {
            val car = Car("pobi")
            `when`("무작위 값이 4 이상일 경우") {
                car.moveOrStop(condition)
                then("움직인다") {
                    car.position shouldBe 2
                }
            }
        }
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `자동차는 무작위 값이 3 이하일 경우 정지한다`(condition: Int) {
        given("자동차가 주어진다.") {
            val car = Car("pobi")
            `when`("무작위 값이 3 이하일 경우") {
                car.moveOrStop(condition)
                then("정지한다") {
                    car.position shouldBe 1
                }
            }
        }
    }
}
