# aop-gustation
AOP 맛보기

## 1. @Aspect
    AOP를 정의 하는 Class에 할당한다.

![image](https://user-images.githubusercontent.com/17442343/120885058-c1a57a80-c621-11eb-87b1-ca0a2ba89ede.png)


## 2. @PointCut
    기능을 어디에 적용 시킬지.

![image](https://user-images.githubusercontent.com/17442343/120884609-f8c65c80-c61e-11eb-9fd0-d17ac1a476be.png)

### 2-1. 명시자
    1. execution: Advice를 적용 할 메소드를 명시할 때 사용.
    2. within: 특정 타입에 속하는 메소드를 JoinPoint로 설정 되도록 명시 할 때 사용.
    3. bean: 스프링 빈을 이용하여 JoinPoint를 설정.

#### 2-1-1. execution
    ✹ execution([수식어] 리턴타임 [클래스이름].이름(파라미터)
    ✹ 수식어 : public, private 등 수식어 명시 (생략 거눙)
    ✹ 리턴 타입 : 리턴 타입을 명시
    ✹ 클래스 이름 및 이름 : 클래스 이름과 메소드 이름을 명시 (클래스 이름은 풀 패키지명으로 명시해야 함. 생략 가능)
    ✹ 파라미터 : 메소드의 파라미터를 명시.
    ✹ "*" : 모든 값을 표현
    ✹ ".." : 0개 이상을 의미.
      수식어 예제는 복잡허니 검색해서 찾아봐야징.

#### 2-1-2. within


#### 2-1-3. bean


## 3. @Before
    메소드 실행하기 이전

![image](https://user-images.githubusercontent.com/17442343/120885107-1f39c700-c622-11eb-9cdd-87fded777c67.png)


## 4. @After
    메소드가 성공적으로 실행 된 후. 예외가 발생하더라도 실행 됨

## 5. @AfterReturing
    메소드 호출 성공 실행시 (Not throws)
    
![image](https://user-images.githubusercontent.com/17442343/120885136-4e503880-c622-11eb-89bc-e7c671a3ad93.png)

## 6. @AfterThrowing
    메소드 호출 실패 예외 발생 (Throws)


## 7. @Around
    Before / After 모두 제어
