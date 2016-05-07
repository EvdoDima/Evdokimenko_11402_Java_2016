package ru.kpfu.itis.forms;

import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.UsersEntity;

/**
 * Created by evdodima on 07/05/16.
 * 11-402
 */
public class NewApplicationForm {

    @NotEmpty(message = "cannot be empty")
    private String name;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    @NotEmpty(message = "cannot be empty")
    private String description;

    private int summ;

    public ApplicationsEntity transformToApplicationEntity(UsersEntity usersEntity) {
        ApplicationsEntity applicationsEntity = new ApplicationsEntity();
        applicationsEntity.setName(getName());
        applicationsEntity.setDescription(getDescription());
        applicationsEntity.setSumm(getSumm());
        applicationsEntity.setCustomer(usersEntity.getCustomer());

        return applicationsEntity;
    }
}
