package monitoring.elasticsearch.demo;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {

	private String id;

//	private DateTime timestamp;

	private String message;

}
