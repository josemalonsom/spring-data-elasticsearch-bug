package com.example;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestBug {

    private static final String ID2 = "id2";
	private static final String ID1 = "id1";
	
	@Autowired
    public TestDocumentRepository repository;

    @BeforeEach
    public void setUp() {

        List<TestDocument> documents =
                Arrays.asList(new TestDocument(ID1, "value1"), new TestDocument(ID2, "value2"));

        repository.deleteAll()
            .thenMany(repository.saveAll(documents))
            .blockLast();
    }

    @Test
    void test() {

    	// How to reproduce:
    	// 1. Start Elasticsearch
    	// 2. Run the test, it should fail as two documents exist
    	// 3. Set a breakpoint in the next line
    	// 4. Run the test in debug mode
    	// 5. Once it's paused in the breakpoint stop Elasticsearch
    	// 6. Resume the execution
    	// 7. The test should pass because the error was silenced
        List<TestDocument> documents = repository.findAllById(Arrays.asList(ID1, ID2))
                .collectList()
                .block();

        assertThat(documents, hasSize(0));
    }

}
