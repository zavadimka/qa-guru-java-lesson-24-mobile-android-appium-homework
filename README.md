<h1 style="text-align: center;">
  <a href="https://school.qa.guru/teach/control/stream/view/id/820646843">QA.GURU | Java | Автоматизация тестирования 24 поток</a>
</h1>

## :pushpin: Домашнее задание к уроку ["24. Мобильная автоматизация #3. Разрабатываем автотесты с эмулятором Android-устройства и на своем телефоне"](https://school.qa.guru/pl/teach/control/lesson/view?id=325083461):

- [x] Настроить рабочий стол:  
  Вариант 1:
    - https://autotest.how/appium-setup-for-local-android-tutorial-md

  Вариант 2:
    - Установить android studio https://developer.android.com/studio
    - Прописать настройки:
      ```
      Параметры Path:
      
      Windows:
      %ANDROID_HOME%\tools
      %ANDROID_HOME%\tools\bin
      %ANDROID_HOME%\platform-tools
      Одной строкой, можно скопировать и добавить в конец Path: ;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools
      
      Mac:
      export ANDROID_HOME=/Users/stanislav/Library/Android/sdk
      export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
      source ~/.bash_profile
      ```
    - В Android Studio -> SDK Manager скачать 11 андроид (если не скачан по умолчанию)
    - В AVD Manager скачать образ Pixel 4 для 11 андроида (если не скачан по умолчанию)
    - Запустить эмулятор телефона, опробовать кнопки и функционал
    - Установить node.js - https://nodejs.org/en/download
    - Установить Appium Server https://github.com/appium/appium
      ```
      sudo npm install -g appium@next
      ```
    - Установить драйвер uiautomator2
      ```
      sudo appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)
      ``` 
    - Установить Appium Ispector https://github.com/appium/appium-inspector
    - Запустить Appium Server
      ```
      appium server --base-path /wd/hub
      ```
- [x] Открыть Appium Inspector, подключиться к эмулятору
    - Изучить функционал Appium Inspector, попробовать найти локатор
- [x] Разработать автотест на getting started (onboarding screen) в приложении википедии - пройти по 4м экранам, на каждом сделать проверку
- [x] Доработать возможность запуска на разных стендах (передать из командной строки -DdeviceHost=browserstack / emulation / real
    - Для каждого сделать драйвер и конфиг с owner

## :arrow_forward: Запуск тестов из командной строки
В проекте предусмотрено выполнение тестов локально с использованием реального и эмулируемого устройств и удаленно с помощью `BrowserStack`, параметры драйвера передаются из соответствующего файла `properties`.
Кромк того в проекте используется тестовое приложение Wikipedia Alfa, которое устанавливается (при первом запуске тестов) на все тестируемые устройства, независимо от заданного драйвера

При выполнении команды тесты запустятся `удаленно` с помощью `BrowserStack`:
```
gradle clean test
```

При выполнении команды тесты запустятся `локально` на реальном устройстве. Необходимо задать свои значения `device.name` и `device.os_version` в `real_device.properties`:
```
gradle clean test -Ddriver=real_device
```

При выполнении команды тесты запустятся `локально` на эмулируемом устройстве. Возможно задать свои значения `device.name` и `device.os_version` в `virtual_device.properties`, тест запускается на `Pixel7_API30_R11`:
```
gradle clean test -Ddriver=virtual_device
```


Параметры web-драйвера могут переопределены с помощью properties и параметров в `Jenkins`:
```
clean test
-Ddriver=${DRIVER}
```
Параметры сборки:

    DRIVER:
    - browserstack (default) - тест запускается удаленно на физическом устройстве с помощью BrowserStack
    - real_device - тест запускается локально на физическом устройстве  
    - virtual_device - тест запускается локально на эмулируемом виртуальном устройстве 