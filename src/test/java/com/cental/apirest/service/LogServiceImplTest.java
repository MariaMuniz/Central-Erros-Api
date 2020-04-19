package com.cental.apirest.service;
import com.cental.apirest.model.Log;
import com.cental.apirest.repository.LogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LogServiceImplTest {
  @Mock
   private LogRepository logRepository;

  @InjectMocks
   private LogServiceImpl logServiceImpl;

   @Test
    public void testFindLogById() {
       mockFindLogById();
       long id = this.logServiceImpl.show(new Long(1)).get().getId();
       assertEquals(1, id);
  }

    private void mockFindLogById() {
        Log log = mock(Log.class);
       when(log.getId()).thenReturn(new Long (1));
        when(this.logRepository.findById(new Long(1))).thenReturn(java.util.Optional.of(log));

    }
}