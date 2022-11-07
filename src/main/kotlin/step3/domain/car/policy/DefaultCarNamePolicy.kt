package step3.domain.car.policy

object DefaultCarNamePolicy : CarNamePolicy {
    override fun isValidName(name: String): Boolean = name.length >= 5
}
