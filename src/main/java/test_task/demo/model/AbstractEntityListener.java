package test_task.demo.model;

import javax.persistence.PrePersist;

public class AbstractEntityListener {
    @PrePersist
    // Аннотация PrePersist указывает, что данный метод будет выполняться каждый раз при вставке новой записи в таблицу
    public void onPrePersist(Comment commentEntity) { commentEntity.uid(); } // А данный метод генерирует ID'шник)
}
