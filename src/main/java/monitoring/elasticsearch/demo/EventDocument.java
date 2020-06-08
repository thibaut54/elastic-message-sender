package monitoring.elasticsearch.demo;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.*;
import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

@Document(createIndex = false, indexName = "events", type = "event", shards = 1, replicas = 0, refreshInterval = "-1"/*, indexStoreType = "memory"*/)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDocument {

	@Id
	private String id;

//	private DateTime timestamp;

	private String message;

}
