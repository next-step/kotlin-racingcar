package step3.domain.car.policy

interface CarNamePolicy {

    fun isValidName(name: String): Boolean
}
