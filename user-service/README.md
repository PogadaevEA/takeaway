Инструкция разработчика

### Развертывание рабочей среды

Требуемое программное обеспечение
1. PostgreSQL 12
2. Gradle 5.x
3. JDK 11
4. IDE, например, IntelliJ IDEA

### Начало работы
1. Создание БД, если она не создана: takeaway\src\main\resources\db\2021.01.01_base.sql
2. В IDE импорт build.gradle
3. Новые миграции liquibase пишутся в ресурсы в директорию db/changelog
4. Запуск приложения: com.home.takeaway.TakeawayApplication. При этом происходит автоматическая миграция БД