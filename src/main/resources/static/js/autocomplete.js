window.onbeforeunload = function() {
    // Очищаем значения полей формы
    document.getElementById("sign-up-form").reset();

    // Отключаем повторную отправку формы при обновлении страницы
    document.getElementById("sign-up-form").setAttribute("autocomplete", "off");
}