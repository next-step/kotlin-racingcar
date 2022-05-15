package racingcar.domain.car

object CarFixture {

    fun getCar(name: String = "장난감차"): Car = Car(name = Name(name))
}
