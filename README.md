### Тесткейсы для авторизации
Набор тестов для проверки функции логина на сайте demoblaze.com

### Описание тесткейсов

#### Успешная авторизация
Тест проверяет возможность авторизации пользователя с валидными учетными данными и состоит из следующих шагов:
- ввод правильного логина и пароля
- проверка успешного входа пользователя в систему
- проверка корректности отображения приветствия с именем пользователя

#### Авторизация с пустыми полями
Тест проверяет работу формы при попытке логина без ввода данных и содержит следующие действия:
- оставляем поля логина и пароля пустым
- проверяем появление сообщения об ошибке "Please fill out Username and Password"

#### Неправильный пароль
Тест на проверку реакции системы на неверный пароль:
- вводим существующий логин и неправильный пароль
- проверяем что система выводит сообщение "Wrong password"

Проведение данных тестов позволяет убедиться в корректной работе функции авторизации и обработке ошибок пользовательского ввода.