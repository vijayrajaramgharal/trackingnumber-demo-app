package  com.user.tracking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TrackingNumberGeneratorService {

	private static final String TRACKING_NUMBER_PREFIX = "TN-";

	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	@Transactional
	@CircuitBreaker(name = "trackingNumberServiceCircuitBreaker", fallbackMethod = "fallbackGenerateTrackingNumber")
	public String generateTrackingNumber() {
		// Generate a unique tracking number
		String trackingNumber = "";
			// Save tracking number to Redis for quick access
			do {
				trackingNumber = TRACKING_NUMBER_PREFIX + UUID.randomUUID().toString();

			} while (redisTemplate.opsForValue().setIfAbsent(trackingNumber, "exists") == null);
		return trackingNumber;
	}

	public String fallbackGenerateTrackingNumber(Throwable t) {
		// Fallback logic
		return "Service is temporarily unavailable. Please try again later.";
	}



}
