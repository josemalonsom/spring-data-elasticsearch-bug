package com.example;

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface TestDocumentRepository extends ReactiveElasticsearchRepository<TestDocument, String>{

}
