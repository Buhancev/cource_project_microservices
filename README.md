
![Logo](https://upload.wikimedia.org/wikipedia/commons/6/67/Note.com_Logo%2C_cropped.png)


## Авторы

- [@white02light](https://www.github.com/white02light)
- [@Buhancev](https://www.github.com/buhancev)


# Веб-приложение "Ваша заметка"

Готовый к использованию REST API микросервис для работы с заметками.

## FAQ

#### Что это?

Это REST API веб-приложение, которое реализуют серверный функционал (backend). Это означает, что для полноценной работы необходим frontend, который будет реализовывать пользовательский интерфейс. 

#### Можно ли обойтись без frontend?

Да! Вы можете отправлять запросы с помощью СURL, Postman, Insomnia.

#### Какие технологии используются в этом веб-приложении?
Стек используемых технологий: Java, SpringBoot, LiquiBase, MySQL, SwaggerUI.


## Документация

- [Swagger UI](https://your-note.ru/swagger-ui.html#)
- [WORD документ](https://github.com/Buhancev/cource_project_microservice/blob/main/readme.docx)


## Краткий пример API

#### Получить все заметки

```http
  GET /api/notes/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  `none`   | `none`   | Возвращаются все заметки,  |
|           |          | созданные пользователем.   |

#### Получить заметку по Id

```http
  GET /api/notes/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. Id нужной заметки     |



## Установка

Установка приложения из githun репозитория

```bash
  git clone https://github.com/Buhancev/cource_project_microservice.git
  cd cource_project_microservice
```
    
## Deployment

To deploy this project run

```bash
  mvn dependency:resolve
  mvn clean package
```


## Обратная связь

Если у Вас есть какие-то пожелания, пожалуйста, напишите нам your-note@fake.com


## Поддержка

За помощью напишите нам на наш email your-note@fake.com или присоединить в наш Discord-сервер Your-Note.


## Сотрудничество

Мы будем рады любому сотрудничеству!

Хотите с нами раборать, но не знаете с чего начать?  Читайте [Сотрудничество с нами](https://github.com/Buhancev/cource_project_microservice/blob/main/CONTRIBUTING.md).

Присоединяйтесь к нашему проекту!
##
правки приглашенной группы 

##
правки приглашенной группы 

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
