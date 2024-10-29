package org.example;

import java.util.Arrays;

public class StringListImpl implements StringList {
    int size;
    final private String[] stringsList;

    public StringListImpl(int size) {
        this.stringsList = new String[size];
    }

    public StringListImpl() {
        this.stringsList = new String[10];
    }


    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public String add(String item) {
        validateItem(item);
        validateSize();
        stringsList[size++] = item;
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    public     String add(int index, String item) {
        validateSize();
        validateIndex(index);
        validateItem(item);
        if (index == size) {
            stringsList[size++] = item;
            return item;
        }
        System.arraycopy(stringsList,index,stringsList,index+1,size-index);
        stringsList[index] = item;
        size++;
        return item;
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        stringsList[index] = item;
        return item;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    public String remove(int index) {
        validateIndex(index);
        if (index == -1) {
            throw new ElementNotFindException();
        }
        String item = stringsList[index];
        if (index == size) {
            System.arraycopy(stringsList,index+1,stringsList,index,size-index);
        }

        size--;
        return item;

    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (stringsList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (stringsList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    public String get(int index) {
        validateIndex(index);
        return stringsList[index];
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    // Вернуть фактическое количество элементов.
    public int size() {
        return size;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    public boolean isEmpty() {
        return size == 0;
    }

    // Удалить все элементы из списка.
    public void clear() {
        size = 0;
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    public String[] toArray() {
        return Arrays.copyOf(stringsList, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == stringsList.length) {
            throw new StringsListIsFUllException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalideIndexException();
        }
    }
}
