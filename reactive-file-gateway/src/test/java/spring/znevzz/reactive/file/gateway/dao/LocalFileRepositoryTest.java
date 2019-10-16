package spring.znevzz.reactive.file.gateway.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import spring.znevzz.reactive.file.gateway.model.FileResource;

@RunWith(SpringRunner.class)
public class LocalFileRepositoryTest {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileResource fileResource;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void demo() {
        fileRepository.readComplete(fileResource);
    }
}