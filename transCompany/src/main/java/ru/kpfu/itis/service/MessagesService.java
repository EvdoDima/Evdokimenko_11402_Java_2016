package ru.kpfu.itis.service;

import ru.kpfu.itis.models.MessagesEntity;

import java.util.List;

/**
 * Created by evdodima on 12/05/16.
 * 11-402
 */
public interface MessagesService {

    void saveNewMessage(MessagesEntity messagesEntity);

    List<MessagesEntity> getAll();
}

