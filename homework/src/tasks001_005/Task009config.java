package tasks001_005;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by evdodima on 24/03/16.
 * 11-402
 */
@Configuration
public class Task009config {

    @Bean
    public ComplexMatrix2x2 nullTest(){
        return  new ComplexMatrix2x2();
    }


    @Bean
    public ComplexMatrix2x2 detTest(){
        ComplexNumber nullN = mock(ComplexNumber.class);
        when(nullN.getIm()).thenReturn(0.0);
        when(nullN.getReal()).thenReturn(0.0);
        when(nullN.add(nullN)).thenReturn(nullN);
        when(nullN.sub(nullN)).thenReturn(nullN);
        when(nullN.mult(nullN)).thenReturn(nullN);

        ComplexNumber n1 = mock(ComplexNumber.class);
        when(n1.getIm()).thenReturn(0.0);
        when(n1.getReal()).thenReturn(1.0);
        when(n1.add(nullN)).thenReturn(n1);
        when(n1.sub(nullN)).thenReturn(n1);
        when(n1.mult(nullN)).thenReturn(nullN);
        when(n1.mult(n1)).thenReturn(n1);


        return new ComplexMatrix2x2(n1, nullN, nullN, n1);

    }
}
