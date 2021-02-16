# 6.1.1.AndroiPetukhova_Lifecycle_and_Log
## Life cycle of Activity./Жизненный цикл активити.  
### Задачи:  
Изучение жизненного цикла активити.  
### Выполнено:  
- Переопределены методы жизненного цикла onCreate, onStart, onResume, onPause, onStop, onDestroy, onRestart, onPostCreate, onPostResume, onKeyDown, onKeyLongPress и onBackPressed. 
- В каждом методе добавлено логирование, Log.d("Lifecycle", methodName), где methodName - это название метода;  
- Сохранение данных в Bundle в методе onSaveInstanceState и восстановление в onRestoreInstanceState.
