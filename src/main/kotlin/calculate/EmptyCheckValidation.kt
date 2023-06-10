package calculate

class EmptyCheckValidation : CalculateValidation {
    override fun validate(input: String) {
        val target = input.replace(" ", "")
        if (target.isEmpty()) {
            throw IllegalArgumentException("입력값이 empty이면 안됨!")
        }
    }
}
