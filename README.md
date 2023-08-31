# Gate Task (Slurm Навыкум "Сборка контейнеров")

## Описание
***

Gate Task &ndash; это пример заданий Навыкума, он поможет определить достаточно ли у вас подготовки для прохождения [Slurm Навыкум "Сборка контейнеров"](https://slurm.io/build-containers) и устраивает ли вас формат Навыкума.

После того, как вы ознакомитесь с примером задачи, то сможете принять более взвешенное решение:

1\. Вам всё нравится и задание по силам &ndash; записывайтесь на [Навыкум](https://slurm.io/build-containers)

2\. Вам всё нравится, но задание не по силам &ndash; прокачивайте свои скиллы и приходите на следующий поток.

У нас есть [курс по Docker](https://slurm.io/docker-intensive), который вы можете пройти, чтобы улучшить свои навыки.

Важно учитывать, что хоть Docker и является основой заданий, для работы вам потребуются и другие инструменты разработки, так как задачи максимально приближены к реальной практике.

3\. Вам не нравится &ndash; пишите нам в [Телеграм Бот](https://t.me/SlurmCustomerBot) о том, что можно изменить или сделать лучше


## Какой подход мы используем в Навыкуме?
***

Всё как в реальной жизни &ndash; куча технологий, разные команды, половина не знает Docker, другая половина пишет `Dockerfile` как попало.

Документации, как обычно, нет, есть только короткие инструкции (если повезёт) о том, как и что запускается и что нужно сделать ("требования" 😈).

И всем нужно помочь, упаковать "их чудо" в образ и предоставить возможность "потестировать".

Раз в неделю мы будем выдавать несколько таких задач, решение которых нужно сдать к дедлайну (после дедлайна сдать их уже будет нельзя).

Особенности формата:
1. Придётся разбираться в коде, в системах управления зависимостями, сборщиках и целевой экосистеме (будут задачи для Java, Go и связанных систем, например, СУБД)
2. Будьте готовы к тому, что те же разработчики иногда сами не знают, как оно должно запускаться в Production (очень редко этому кого-то учат)
3. Задачи будут ставиться так, как они ставятся в реальной практике (парой сообщений в мессенджере или таск-трекере со ссылкой на код без доков)

## Пример задачи
***

**Важно**: Это задача без проверки, присылать ответ никуда не нужно!

Для решения Gate Task необходимо использовать Docker для сборки образа контейнера.

В качестве Gate Task &ndash; сервис на Java, который умеет считать кэшбек.

### Формулировка разработчика

Разработчик сказал следующее (дословно):
> Стандартный проект на Spring, целевая версия Java - 8.
>
> Для сборки нужен Maven 3.9.x. Собирается командой `mvn package`.
> 
> Запускается командой `java -jar cashback-service.jar`.
>
> Для проверки нужно отправить через `POST` JSON на `http://localhost:8080/api/cashback` следующего вида:
> ```json
> {"amount": 100}
> ```
> 
> В ответ должно прийти:
> ```json
> {"cashback": 3}
> ```

Что нужно сделать (дословно):
> Упаковать всё в Docker так, чтобы можно было процент и лимит задавать через переменные окружения `APP_PERCENT` и `APP_LIMIT` соответственно (по умолчанию &ndash; 3 и 3000)
>
> В качестве базового образа хотим использовать официальный образ Java 8 Eclipse Temurin с [апдейтом не ниже 382-b05](https://mail.openjdk.org/pipermail/jdk8u-dev/2023-July/017285.html)
>
> Никаких entrypoint.sh и других sh-скриптов писать не нужно
>
> Никаких тестов, проверок стиля кода, проверок безопасности (в том числе сканирования зависимостей и образов на уязвимости), подписывания образов и т.д. делать не нужно
> 
> Для сборки использовать Multi-Stage, в финальном образе должна быть только Java (Maven'а быть не должно)
>
> Выложить всё в виде публичного образа на GHCR (GitHub Container Registry), чтобы мы могли сами затестить и переиспользовать

### Требования
***
Ко всем заданиям в Навыкуме будут применяться следующие требования:
1. Всё должно быть оформлено в виде публичного репозитория на GitHub
2. Вся сборка образов должна проходить через GitHub Actions
3. Образ должен выкладываться в GitHub Container Registry (GHCR), для этого необходимо использовать [GitHub Actions](https://github.com/features/actions)

К текущему заданию дополнительно предъявляются требования:
1. Docker Legacy Build ([`DOCKER_BUILDKIT=0 docker build .`](https://github.com/docker/cli/pull/3314))
2. Multi-Stage

В других заданиях Навыкуме, конечно же, будут и другие требования, например, наоборот, использовать BuildKit и т.д.
***
<details>
<summary>Спойлеры</summary>

Спойлеры смотреть не хорошо 😈!

Основные моменты:
1. Не запускайте приложение от root'а (прописывайте это явно в `Dockerfile`)
2. Точно указывайте базовый образ (как минимум, с точностью до minor-версии, использование digest &ndash; также допустимо)

</details>
