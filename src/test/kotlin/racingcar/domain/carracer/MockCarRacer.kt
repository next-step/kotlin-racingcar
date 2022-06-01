package racingcar.domain.carracer

class MockCarRacer(private val result: Int) : CarRacer {

    override fun drive(): Int = result
}
