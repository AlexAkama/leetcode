# СОВЕТЫ

### Если входной массив отсортирован: 
- Бинарный поиск
- Два указателя

### Если связанный список:
- Два указателя

### Если требуется найти все перестановки/подмножества:
- Поиск с возвратом ([Backtracking](https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D0%B8%D1%81%D0%BA_%D1%81_%D0%B2%D0%BE%D0%B7%D0%B2%D1%80%D0%B0%D1%82%D0%BE%D0%BC))

### Если дерево или граф:
- Обход в ширину ()
- Обход в высоту ()

### Если запрещена рекурсия:
- Stack

### Если необходимо решить "на месте":
- Менять местами соответствующие значения.
- Сохранять одно или несколько значений в одном указателе.

### Если запрашивается максимальный/минимальный подмассив/модмножество/параметр:
- Динамическое программирование

### Если нужны первые/последние k значений:
- Heap

### Если запрашиваются общие строки
- Map
- Tree
#### Иначе
- Map/Set - O(1) по времени доступа и O(n) по памяти.
- Сортировка на входе - O(n*log(n)) по времени и O(1) по памяти.

## Дополнительно
[Видосик про алгоритмы](https://youtu.be/CB9bS46vl04)  
**02:08** ＃1. Метод грубой силы / полный перебор / исчерпывающий поиск (Brute-Force)  
**03:38** ＃2. Разделяй и властвуй / метод декомпозиции (Divide and Conquer)  
**05:40** ＃3. Динамическое программирование (Dynamic Programming)  
**07:34** ＃4. Жадный алгоритм (Greedy Algorithm)  
**09:33** ＃5. Поиск с возвратом (Backtracking)  
**11:56** ＃6. Локальный поиск (Local Search)  
**13:34** ＃7. Преобразуй и властвуй / метод преобразования (Transform and Conquer)