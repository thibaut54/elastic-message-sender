package monitoring.elasticsearch.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.joda.time.DateTime;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
//@CrossOrigin("*")
public class EventController {

	private final EventElasticsearchRepository eventRepository;
	private final RestHighLevelClient elasticsearchClient;

	@PostMapping("/event")
	public void sendEvent(@RequestBody EventDTO eventDTO) throws IOException {

		eventRepository.save( EventDocument.builder()
				                      .message( eventDTO.getMessage() )
//				                      .timestamp( DateTime.now(  ) )
				                      .build() );

		GetIndexRequest getIndexRequest = new GetIndexRequest("events");
		boolean indexExists = elasticsearchClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
		log.info( "EVENT DOCUMENT INDEX CREATED : " + String.valueOf( indexExists ));
	}

	@GetMapping("/test")
	public String test(){
		return "hello";
	}
}
