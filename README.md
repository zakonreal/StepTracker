# Техническое задание

Компания по производству спортивных носков решила разработать свой счётчик калорий для дополнительной мотивации ведения здорового образа жизни. Написать прототип приложения поручили вам.
Оно должно предоставлять следующий функционал:
- Консольный интерфейс для управления программой;
- Хранение данных о количестве пройденных шагов за несколько месяцев;
- Ввод вашей цели по количеству шагов в день;
- Ввод пройденного количества шагов за день;
- Вывод статистики за определённый месяц.

# Класс ```Main```

В этом классе реализован основной цикл приложения — считывание команд и вызов соответствующих методов основного класса приложения — ```StepTracker```. Вся работа с пользовательским вводом и выводом осуществляется в этом классе.
Пользователь взаимодействует с приложением через консольный интерфейс, который позволяет произвести одно из действий по выбору:
- Ввести количество шагов за определённый день;
- Напечатать статистику за определённый месяц;
- Изменить цель по количеству шагов в день;
- Выйти из приложения.

# Класс ```StepTracker```

Это класс с основной логикой приложения — в нём хранится информация о пройденных шагах, реализована логика по сохранению и изменению количества шагов, а так же рассчитывается статистика.

В классе реализована следующая функциональность:
- Сохранение количества шагов за день.
- Подсчёт и вывод статистики за указанный пользователем месяц. 
- Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
- Изменение целевого количества шагов. Данные вводятся пользователем. Введённое значение не должно быть отрицательным.

# Класс ```Converter```
В этом классе осуществляется преобразование шагов в километры и калории.
- Для подсчёта дистанции можно считается, что один шаг равен 75 см.
- Для подсчёта количества сожжённых килокалорий считается, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.
