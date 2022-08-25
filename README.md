# Cafe

## Основные функции

Данное приложение является учебно-тестовым проектом. Через него, по идее, оформляется заказ из кофе. Можно заказать:

* Кофе
    * Экспрессо
    * Американо
    * Американо
* Чай
    * Черный
    * Зелёный
Также можно указать и добавки: сахар, молок и, доступен только для *чая*, лимон.

## Что было изучено и использовано

### Из макета ([layout](https://github.com/MrDragoRozum/Cafe/blob/main/app/src/main/res/layout/activity_make_order.xml)):

* RadioGroup
* RadioButton
* CheckBox
* Spinner
* ImageView
* ScrollView

### Из кода (Activity)

* Фабричный метод (иная реализация Intent)
* Был использован метод format() для замены %s на нужный текст
* Получение элемента из Spinner
* Слушатель из RadioGroup
* Взаимодействовал с CheckBox

### Прочее

* Использован впервые array в string.xml для Spinner
* Загрузка изображение в Adnroid Studios (SVG и PNG)

### Трудности

Сложность была из-за бага, который сжимал квадратно ImageView у макета activity_main.xml, вплоть, что изображение пропадало.
Данный баг был решён через ScrollView. 
Источник: https://stackoverflow.com/a/21202586

## Демонстрация работы приложения


https://user-images.githubusercontent.com/107046079/186671259-2cd4f2d5-b8f8-451e-8994-cc5039fd631d.mp4

