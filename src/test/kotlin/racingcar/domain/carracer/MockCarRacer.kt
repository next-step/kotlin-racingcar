package racingcar.domain.carracer

class MockCarRacer(private val result: Int) : CarRacer {

    override fun race(): Int = result
}
