# kotlin-racingcar

## 🚀 2단계 - 문자열 계산기

- [ ] 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
- [ ] 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 
  - [ ] 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
  - [ ] 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [ ] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [ ] 사칙 연산을 모두 포함하는 기능 구현
- [ ] 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다. 
- [ ] 반복적인 패턴을 찾아 반복문으로 구현한다.
- [x] Parameterized Tests 활용

### 고민

- data class 에 부생성자로 `value: String`을 받은 후 `value: Int`로 변경해서 사용하고 싶었는데 포기
  - data class 에 주생성자 이외 추가 생성자를 만드는건 data class의 의미가 희석되는거 같다..
  - 주생성자를 private하게 가려도 copyOf() 메서드를 통해 노출된다고 IDE가 경고함

<br>
