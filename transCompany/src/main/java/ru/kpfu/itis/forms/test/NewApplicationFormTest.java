package ru.kpfu.itis.forms.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.itis.forms.NewApplicationForm;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.CustomersEntity;
import ru.kpfu.itis.models.UsersEntity;

import static org.junit.Assert.*;

/**
 * Created by evdodima on 14/05/16.
 * 11-402
 */
public class NewApplicationFormTest {

    NewApplicationForm newApplicationForm;

    @Before
    public void setUp() throws Exception {
         newApplicationForm = new NewApplicationForm();
        newApplicationForm.setName("application");
        newApplicationForm.setDescription("description");
        newApplicationForm.setSumm(1);



    }

    @Test
    public void transformToApplicationEntity() throws Exception {


        UsersEntity usersEntity = new UsersEntity();
        CustomersEntity customersEntity = new CustomersEntity();
        usersEntity.setCustomer(customersEntity);

        ApplicationsEntity applicationsEntity =
                newApplicationForm.transformToApplicationEntity(usersEntity);


        Assert.assertEquals(applicationsEntity.getCustomer(),customersEntity);
        Assert.assertEquals(newApplicationForm.getDescription(),"description");
        Assert.assertEquals(newApplicationForm.getName(),"application");
        Assert.assertEquals(newApplicationForm.getSumm(),1);




    }
}