package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.MessagesEntity;
import ru.kpfu.itis.rep.MessagesRep;
import ru.kpfu.itis.service.MessagesService;

import java.util.List;

/**
 * Created by evdodima on 12/05/16.
 * 11-402
 */
@Service
public class MessagesServiceImpl implements MessagesService{
    @Autowired
    MessagesRep messagesRep;

    @Override
    public void saveNewMessage(MessagesEntity messagesEntity) {
        messagesRep.save(messagesEntity);
    }

    @Override
    public List<MessagesEntity> getAll() {
        return messagesRep.findAll();
    }
}
