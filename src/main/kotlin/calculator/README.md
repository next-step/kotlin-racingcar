## 2단계 - 문자열 계산기

### 기능 요구 사항
- 입력
  - 사용자는 숫자와 연산 기호로 이루어진 값을 입력할 수 있다.
  - 숫자와 연산 기호 사이는 공백으로 구분된다.
- 계산기 기능
  - 들어온 값의 순서대로 계산을 진행한다.
  - 크게 4가지의 기능을 제공한다.
    - 덧셈 
    - 뺄셈
    - 곱셈
    - 나눗셈
      - 0으로 나누는 경우에 대해 `IllegalArgumentException`을 발생시킨다.
    - 입력값이 null이거나 빈 공백 문자가 들어오면 `IllegalArgumentException`을 발생시킨다.
    - +, -, *, / 가 아니라면 `IllegalArgumentException`을 발생시킨다.
    - 피연산자가 숫자값이 아니면 `IllegalArgumentException`을 발생시킨다.
