package racing

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarNameMapperTest : FunSpec({
    test("racing prepare시 position은 0으로 초기화()") {
        // Given
        val names: List<String> = listOf("Jiwon", "Alex", "Bob")

        // When
        val cars = CarNameMapper.map(names)

        // Then
        for (car in cars) {
            car.position shouldBe 0
        }
    }
})
