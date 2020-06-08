package monitoring.elasticsearch.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventElasticsearchRepository extends ElasticsearchRepository< EventDocument, String > {

//	List<BookDocument> findAllByTitleContains(String title);
}
