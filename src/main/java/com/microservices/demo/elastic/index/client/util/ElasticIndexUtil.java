package com.microservices.demo.elastic.index.client.util;

import com.microservices.demo.elastic.model.index.IndexModel;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElasticIndexUtil<T extends IndexModel> {

    public List<IndexQuery> getIndexQueries(List<T> documents) {
        return documents.stream()
                .map(doc -> new IndexQueryBuilder()
                        .withId(doc.getId())
                        .withObject(doc)
                        .build()
                ).toList();
    }

}
