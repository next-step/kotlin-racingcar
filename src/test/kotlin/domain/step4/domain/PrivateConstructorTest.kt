package domain.step4.domain

import org.junit.jupiter.api.Test

class PrivateConstructorTest {

    @Test
    fun `value 클래스애 대한 테스트를 실행하면 문제가 발생한다`() {
        val privateConstructor = PrivateConstructor.of(listOf())
    }

}