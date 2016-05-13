package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.MessagesEntity;

/**
 * Created by evdodima on 12/05/16.
 * 11-402
 */
public interface MessagesRep extends JpaRepository<MessagesEntity,Long> {
}
