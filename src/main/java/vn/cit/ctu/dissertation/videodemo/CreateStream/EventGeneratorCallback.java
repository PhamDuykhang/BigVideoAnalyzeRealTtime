package vn.cit.ctu.dissertation.videodemo.CreateStream;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;

public class EventGeneratorCallback implements Callback {
	private static final Logger logger = Logger.getLogger(EventGeneratorCallback.class);
	private String camId;

	public EventGeneratorCallback(String camId) {
		super();
		this.camId = camId;
	}

	@Override
	public void onCompletion(RecordMetadata rm, Exception e) {
		if (rm != null) {
			logger.info("cameraId="+ camId + " partition=" + rm.partition());
		}
		if (e != null) {
			e.printStackTrace();
		}
	}

}
