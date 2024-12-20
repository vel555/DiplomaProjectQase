# Тест кейсы для Qase.io

## Авторизация

1. **Тест кейс 1: Успешная авторизация**
    - **Шаги:**
        1. Открыть страницу авторизации.
        2. Ввести корректный email и пароль.
        3. Нажать кнопку "Войти".
    - **Ожидаемый результат:** Пользователь успешно авторизуется и попадает на главную страницу.

2. **Тест кейс 2: Неуспешная авторизация с неверным паролем**
    - **Шаги:**
        1. Открыть страницу авторизации.
        2. Ввести корректный email и неверный пароль.
        3. Нажать кнопку "Войти".
    - **Ожидаемый результат:** Появляется сообщение об ошибке "These credentials do not match our records.".

3. **Тест кейс 3: Авторизация с несуществующим email**
    - **Шаги:**
        1. Открыть страницу авторизации.
        2. Ввести несуществующий email и любой пароль.
        3. Нажать кнопку "Войти".
    - **Ожидаемый результат:** Появляется сообщение об ошибке "These credentials do not match our records.".

4. **Тест кейс 4: Пустые поля для авторизации**
    - **Шаги:**
        1. Открыть страницу авторизации.
        2. Оставить поля email и пароль пустыми.
        3. Нажать кнопку "Войти".
    - **Ожидаемый результат:** Появляется сообщение об ошибке "This field is required".

5. **Тест кейс 5: Авторизация с помощью соцсетей**
    - **Шаги:**
        1. Открыть страницу авторизации.
        2. Нажать на кнопку авторизации через соцсеть (например, Google).
    - **Ожидаемый результат:** Открывается окно авторизации выбранной соцсети.

## Создание проекта

1. **Тест кейс 1: Успешное создание проекта**
    - **Шаги:**
        1. Нажать кнопку "Create new project".
        2. Ввести название проекта и описание.
        3. Нажать кнопку "Create project".
    - **Ожидаемый результат:** Проект успешно создан и переходим на страницу проекта.

2. **Тест кейс 2: Создание проекта с пустым названием**
    - **Шаги:**
        1. Нажать кнопку "Create new project".
        2. Оставить поле названия пустым.
        3. Нажать кнопку "Create project".
    - **Ожидаемый результат:** Появляется сообщение об ошибке "Заполните это поле".

3. **Тест кейс 3: Удаление проекта**
    - **Шаги:**
        1. на странице проектов выбрать нужныйдля удаления.
        2. Нажать три точки в строке выбраного проекта.
        3. В выпадающем меню нажать Remove.
        4. Впоявившемся модальном окне нажать "Delete project"
    - **Ожидаемый результат:** Возвращаемся на страницу проектов, проект удален .

4. **Тест кейс 4: Создание проекта без описания**
    - **Шаги:**
        1. Нажать кнопку "Create new project".
        2. Ввести название проекта и оставить описание пустым.
        3. Нажать кнопку "Create project".
    - **Ожидаемый результат:** Проект успешно создан без описания и переходим на страницу проекта.

5. **Тест кейс 5: Создание проекта с недопустимыми символами**
    - **Шаги:**
        1. Нажать кнопку "Create new project".
        2. Ввести название проекта с недопустимыми символами (например, @#$%).
        3. Ввести код проекта с недопустимыми символами (например, @#$%).
        4. Нажать кнопку "Create project".
    - **Ожидаемый результат:** Появляется сообщение об ошибке "The code format is invalid.".

## Создание сьюта

1. **Тест кейс 1: Успешное создание Suites**
    - **Шаги:**
        1. Нажать кнопку  создания Suites.
        2. Ввести название Suites и выбрать проект.
        3. Нажать кнопку "Create".
    - **Ожидаемый результат:** Suites успешно создан и отображается в списке Suites.
        появляется аллерт с сообщением "Suite was successfully created."

2. **Тест кейс 2: Создание Suites с пустым названием**
    - **Шаги:**
        1. Нажать кнопку  создания Suites.
        2. Оставить поле названия пустым.
        3. Нажать кнопку "Create".
   - **Ожидаемый результат:** Появляется сообщение об ошибке "Заполните это поле".

3. **Тест кейс 3: Удаление Suites**
    - **Шаги:**
        1. На странице проекта в списке сют найти название для удаления.
        2. Нажать три точки возле названия Suites.
        3. В выпадающем меню нажать Delete.
        4. В появившемся окне с вопросом"Are you sure that you want to delete the suite" нажать Delete.
    - **Ожидаемый результат:** Появляется аллерт с сообщением "Suite was successfully deleted.".

